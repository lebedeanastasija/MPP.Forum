<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
<h1>Sign up</h1>
<h2>${msg}</h2>
<form method="POST" action="/signup/create"
                    commandName="userData">
    <label></label>
    <table>
        <tr>
            <td colspan="2">
                User data:
            </td>
        </tr>
        <tr>
            <td>Login:</td>
            <td><input path="login" type="text"/></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input path="password" type="number"/></td>
        </tr>
        <tr>
            <td colspan="2">
                Passport data:
            </td>
        </tr>
        <tr>
            <td>Passport Number:</td>
            <td><input path="passportNumber" type="number"/></td>
        </tr>
        <tr>
            <td>Name:</td>
            <td><input path="name" type="text"/></td>
        </tr>
        <tr>
            <td>Surname:</td>
            <td><input path="surname" type="text"/></td>
        </tr>
        <tr>
            <td>Patronymic:</td>
            <td><input path="patronymic" type="text"/></td>
        </tr>
        <tr>
            <td>Birthday:</td>
            <td><input path="birthday" type="date"/></td>
        </tr>
        <tr>
            <td>Series:</td>
            <td><input path="series" type="text"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="send"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>