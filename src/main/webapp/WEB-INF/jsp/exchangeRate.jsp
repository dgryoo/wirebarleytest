<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>환율계산</h1>
<h2>송금국가 : 미국(USD)</h2>
<h2 style="display: inline">수취국가 : </h2>
<select id="country" onchange="getExchangeRateString()" style="display: inline">
    <option value="KRW" selected>한국(KRW)</option>
    <option value="JPY">일본(JPY)</option>
    <option value="PHP">필리핀(PHP)</option>
</select>

<br><br>

<h2 style="display: inline">환율 : </h2>
<h2 id="exchangeRate" style="display: inline"></h2>
<h2 id="exchangeRateName" style="display: inline"></h2>
<h2>송금액 : <input id="usdCount" type="text"> USD</h2>
<input type="submit" value="Submit" name="addition" onclick="return calculateExchangeRateValue()">
<h2 id="exchangeRateValue" style="display: none;"></h2>

<script>
    async function getExchangeRateString() {
        const sel = document.getElementById("country");
        const url = "http://localhost:8080/exchangeRateObject?recipientCountry=" + sel.options[sel.selectedIndex].value;
        const response = await fetch(url);
        const data = await response.json();
        document.getElementById("exchangeRate").textContent = data['exchangeRate'];
        document.getElementById("exchangeRateName").textContent = data['exchangeRateName'];
    }

    getExchangeRateString()

    async function calculateExchangeRateValue() {
        const usdCount = document.getElementById("usdCount").value;

        if (!usdCount || usdCount > 10000 || usdCount <= 0) {
            alert("송금액이 바르지 않습니다");
        } else {
            const exchangeRate = document.getElementById("exchangeRate").textContent;
            const sel = document.getElementById("country");
            const url = "http://localhost:8080/exchangeRateValue";
            const exchangeRateCondition = "?exchangeRateString=" + exchangeRate;
            const usdCountCondition = "&usdCount=" + usdCount;
            const response = await fetch(url + exchangeRateCondition + usdCountCondition);
            const data = await response.text();
            document.getElementById("exchangeRateValue").textContent =
                "수취금액은 " + data + " " + sel.options[sel.selectedIndex].value + " 입니다.";
            document.getElementById("exchangeRateValue").style.display = 'block';
        }
    }

</script>

</body>
</html>
