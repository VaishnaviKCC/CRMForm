<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'account.label', default: 'Account')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head> 
    <body>
        <div class="jumbotron">
  <h1>CRM form</h1>
  <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
  <p><a href="${createLink(action: 'create')}" role="button"> </a></p>
</div>
    </body>
</html>