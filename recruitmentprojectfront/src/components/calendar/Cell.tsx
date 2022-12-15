import clsx from "clsx";
import React from "react";

interface Props extends React.PropsWithChildren {
    isActive? : boolean;
    onClick?: () => void;
    className?: string;
}

const Cell: React.FC<Props> = ({isActive = false, onClick, className, children}) => {
    return(
    <div
    onClick={isActive ? undefined : onClick}     
        className={clsx("h-12 flex items-center justify-center border-b border-r",
        {"text-white bg-blue-600": isActive},
        {"cursor-pointer hover:bg-gray-100 active:bg-gray-200": !isActive && onClick },
        className
        )}
        >
            {children}
        </div>
    );
};
export default Cell;