import React, {useState} from "react";

export const Register = (props) => {
    const [email, setEmail] = useState('');
    const [pass, setPass] = useState('');
    const [firstName, setFirstName] = useState('');
    const [lastName, setLastName] = useState('')

    const handleSubmit = (e) => {
        e.preventDefault();
        console.log(email);
        fetch('http://localhost:8080/api/v1/registration/register', {
    method: 'POST',
    headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
    },
    body: JSON.stringify({ "firstName": firstName, "lastName": lastName, "email": email, "password": pass })
})
.then(response => response.json())
.then(response => console.log(JSON.stringify(response)))
    }

    return (
        <div className="auth-form-container">
            <h2>Register</h2>
            <form className="register-form" onSubmit={handleSubmit}>
                <label htmlFor="firstName">First Name</label>
                <input value={firstName} name="firstName" id="firstName"placeholder="Intorduce yourself"/>
                <label htmlFor="Last Name">Last Name</label>
                <input value={lastName} name="lastName" id="lastName"placeholder="Intorduce yourself"/>
                <label htmlFor="email">email</label>
                <input value={email} onChange={(e) => setEmail(e.target.value)}type="email"placeholder="youremail@gmail.com" id="email" name="email"/>
                <label htmlFor="password">password</label>
                <input value={pass} onChange={(e) => setPass(e.target.value)}type="password"placeholder="********" id="password" name="password"/>
                <button typer="submit">Register</button>
            </form>
            <button className="link-btn" onClick={() => props.onFormSwitch('login')}>Already have an account? Login here.</button>
        </div>
    )
}