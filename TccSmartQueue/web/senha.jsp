<%-- 
    Document   : senha
    Created on : 03/03/2017, 19:20:03
    Author     : brunacm
--%>

<?xml version='1.0' encoding='UTF-8' ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://xmlns.jcp.org/jsf/html"
      xmlns:f="http://xmlns.jcp.org/jsf/core">
    <head>
        <meta charset="UTF-8">
        <meta name="description" content="Gerenciador de filas">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <title>Smartqueue</title>
        <link rel="stylesheet" type="text/css" href="estilos/estilo.css" />
        <link rel="stylesheet" type="text/css" href="estilos/unsemantic-responsive.css" />
    </head>
    <body>
        <%@include file="WEB-INF/jspf/cabecalho.jspf"%>
        
        <div class="main">
            <div class="grid-25 gera-senha">
            <c:choose>  
                <c:when test="${empty dadossenha}">
                    <p>Nenhum dado!</p>
                </c:when>
                <c:otherwise>
                    <label>Tempo m�dio de atendimento</label>
                    <h1>${dadossenha.tempo_medio}</h1>
                    
                    <!--<label>Ultima Senha Chamada</label>
                    <h2>{dadossenha.ultima_senha_atendida}</h2>
                    
                    <label>Ultima Senha Gerada</label>
                    <h2>{dadossenha.ultima_senha_gerada}</h2>                
                    -->
                    <label>Quantidade de pessoas na Fila</label>
                    <h1>${dadossenha.quantidade_pessoas}</h1>
                                      
                </c:otherwise>
            </c:choose>
            <div class="grid-100">
                <input type="button" value="Gerar Senha" onClick="window.location.href='GeraSenhaServlet'">
            </div>
            </div>
        </div>
       <%@include file="WEB-INF/jspf/rodape.jspf"%>
    </body>
</html>