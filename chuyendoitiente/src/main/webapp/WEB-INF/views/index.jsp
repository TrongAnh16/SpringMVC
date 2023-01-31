<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Greeting</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<fieldset style="margin-left: auto; margin-right: auto; max-width: 400px">--%>
<%--    <legend>Currency Converter</legend>--%>
<%--    <form>--%>
<%--        <div>--%>
<%--            <label for="type">Select type</label>--%>
<%--            <select id="type">--%>
<%--                <option value="v2d">VND to USD</option>--%>
<%--                <option value="u2v">USD to VND</option>--%>
<%--            </select>--%>
<%--        </div>--%>
<%--        <div>--%>
<%--            <label for="inputAmount">Amount</label>--%>
<%--            <input type="number" name="amount" id="inputAmount"/>--%>
<%--        </div>--%>
<%--        <div>--%>
<%--            <label for="inputRate">Rate of Exchange</label>--%>
<%--            <input type="number" name="rate" id="inputRate"/>--%>
<%--        </div>--%>
<%--        <div>--%>
<%--            <input type="submit" name="change" id="submitChange">--%>
<%--        </div>--%>
<%--    </form>--%>
<%--</fieldset>--%>
<%--</body>--%>
<%--</html>--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>currency converter</title>
</head>
<body>
<form method="post" action="/usd">
    <label>Rate: </label>
    <input type="text" name="rate" placeholder="Rate" value="22000"><br>
    <label>USD: </label>
    <input type="text" name="usd" placeholder="USD" value="0"><br>
    <input type="submit" id="submit" value="Converter">
</form>
</body>
</html>