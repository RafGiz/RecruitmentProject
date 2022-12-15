import React from "react";
import Cell from "./Cell";

const Calendar = () => {
    return (
        <div className="w-[400px border-t border-l">
            <div className="grid grid-cols-7 items-center 
            justify-center text-center">
                <Cell>{"<<"}</Cell>
                <Cell>{">"}</Cell>
                <Cell className="col-span-3"> August 2022</Cell>
                <Cell>{">"}</Cell>
                <Cell>{">>"}</Cell>

                <Cell>Sun</Cell>
                <Cell>Mon</Cell>
                <Cell>Tue</Cell>
                <Cell>Wed</Cell>
                <Cell>Thu</Cell>
                <Cell>Fri</Cell>
                <Cell>Sat</Cell>

            </div>
        </div>
    );
};
export default Calendar;