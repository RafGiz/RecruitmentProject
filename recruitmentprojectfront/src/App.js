import React, { useState} from "react";
import { BrowserRouter } from "react-router-dom";
import './App.css';
import ButtonAppBar from './components/Appbar';
import User from './components/User';
import {Login} from "./Login";
import {Register} from "./Register";
import {Helmet} from "react-helmet";
import { format } from "date-fns";

function App() {
  
  const [currentForm, setCurrentForm] = useState('login');

  const [currentDate, setCurrentDate] = useState(new Date());

  const handleSetToday = () => setCurrentDate(new Date());

  const toggleForm = (formName) => {
    setCurrentForm(formName);
  }

  return (
        
      
        <div className="App">
          {/* <div className="flex flex-col items-center gap-2">
            <p>Selected Date of Test: {format(currentDate, "dd LLLL yyyy")}</p>
            <button onClick={handleSetToday} className="text-sm px-4 py-1 rounded text-white bg-blue-600 
            hover:bg-blue-700 active:bg-blue-800" 
            > Today </button>
          </div> */}
          <BrowserRouter>
          <Helmet>
                <meta charSet="utf-8" />
                <title>Consumer Research Laboratory</title>
                <link rel="canonical" href="http://mysite.com/example" />
                <meta name="description" content="Helmet application" />
          </Helmet>
          {
            currentForm === "login" ? <Login onFormSwitch={toggleForm} /> : <Register onFormSwitch={toggleForm}/>
          }
          
         </BrowserRouter>
          {/* <Calendar value={currentDate} onChange={setCurrentDate} /> */}
        </div>
      );
    }            

export default App;
