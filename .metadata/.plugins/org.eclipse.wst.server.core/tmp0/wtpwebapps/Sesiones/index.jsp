<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.educacionit.entidades.Usuario" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mi primera sesion</title>
</head>
<body>


<h1>Titulo del Proyecto</h1>

<%
  String mensaje = (String) session.getAttribute("mensaje");
  Usuario usuario = (Usuario) session.getAttribute("usuario");
  String id = (String) session.getAttribute("id");
  
  if(usuario==null){
	  response.sendRedirect("formulario.jsp");
  }
  
%>

<h1><%=mensaje %></h1>
<h2><%=usuario.getCorreo() %></h2>
<h3><%="Numero de sesion: "+id %></h3>

<a href="Login?sesion=true">Cerrar Sesion</a>

</body>
</html>
