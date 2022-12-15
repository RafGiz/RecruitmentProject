import { Outlet } from "react-router";
import { Register } from "./Register";
import { useLocation } from "react-router";
import {Navigate, Outlet} from "react-router-dom";

const useAuth = () => {
    const user = {loggedIn: false}
    return user && userloggedIn;
};

const Protected = () => {
    const location = useLocation()
    const isAuth = useAuth();
    return isAuth ? (
    <Outlet />
     ) : (
     <Navigate to="/" replace state={{from: location}}/>
     );
};
export default ProtectedRoutes;

