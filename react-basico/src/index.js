import React from 'react';
import ReactDOM from 'react-dom/client';
import Funciones from './Funciones'
import Clases from './Clases';


const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
     
<React.StrictMode>
    <Funciones titulo="Java Web API" subtitulo="Curso de Java" parrafo="Inscribete Ya..."/> 
   
    <Funciones titulo="SQL" subtitulo="Curso de SQL" parrafo="Inscribete Ya..."/> 
    
    <Clases descripcion="Hola esta es una propiedad desde una clase"/>
   
</React.StrictMode>


  );

//Funciones y Clases
  