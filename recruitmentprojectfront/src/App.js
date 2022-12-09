import React, { useState} from "react";
import './App.css';
import ButtonAppBar from './components/Appbar';
import User from './components/User';
import {Login} from "./Login";
import {Register} from "./Register";
import {Helmet} from "react-helmet";

function App() {
  const [currentForm, setCurrentForm] = useState('login');

  const toggleForm = (formName) => {
    setCurrentForm(formName);
  }

  return (
        <div className="App">
          <Helmet>
                <meta charSet="utf-8" />
                <title>Consumer Research Laboratory</title>
                <link rel="canonical" href="http://mysite.com/example" />
                <meta name="description" content="Helmet application" />
          </Helmet>
          {
            currentForm === "login" ? <Login onFormSwitch={toggleForm} /> : <Register onFormSwitch={toggleForm}/>
          }
          
        </div>
      );
    }            

export default App;
