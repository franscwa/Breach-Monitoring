import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import View from './Components/view'
import reportWebVitals from './reportWebVitals';
import MyElement from './Components/test';
import App from './App'
import Sidebar from './Components/sidebar';
import { Navbar } from 'react-bootstrap';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
   
    <View />
    <Sidebar />
    <App />
     
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
