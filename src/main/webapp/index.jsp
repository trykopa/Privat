<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <title>User Management Application</title>
</head>
<body>
<div style="text-align: center;">
    <h2>Privat API Test</h2>
    <br>
    <h4>Поиск информации о курсе USD по дате или среднего значения по диапазону дат</h4>
</div>


<div class="container" align="center" style="width: 1000px;">
    <table class="table table-bordered table-hover table-condensed" border="1" cellpadding="2">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Поиск по дате</th>
            <th scope="col" style="width: 250px;">Результат</th>
        </tr>
        </thead>
        <tr>
            <th scope="col">
                <form action = "controller" method="post">
                    <label>Дата:
                        <input type="date" name="date" required><br/>
                    </label>
                    <button type="submit" name="form" value="form1">Submit</button>
                </form>
            </th>

            <th scope="col">
                <label> Стоимость покупки USD:
                    <c:out value="${purchase}" /> <br/>
                </label>
                <br/>
                <label> Стоимость продажи USD:
                    <c:out value="${sale}" /><br/>
                </label>
            </th>
        </tr>
        <thead class="thead-dark">
        <tr>
            <th scope="col">Поиск по среднего по диапазону</th>
            <th scope="col" >Результат</th>
        </tr>
        </thead>
        <tr>
            <th scope="col">
                <form action = "controller" method="post">
                    <label>Начальная дата:
                        <input type="date" name="datestart" required><br />
                    </label>
                    <label>Конечная дата:
                        <input type="date" name="dateend" required><br />
                    </label>
                    <button type="submit" name="form" value="form2">Submit</button>
                </form>
            </th>
                <th>
                    <label>
                        Средняя стоиость за период <c:out value="${datestart}" /> - <c:out value="${dateend}" />
                        <br>
                    </label>
                    <label>Средняя стоимость покупки USD: </label>
                    <c:out value="${avpur}" /> <br>
                    <label>Средняя стоимость продажи USD: </label>
                    <c:out value="${avsale}" />
                </th>
             </tr>

    </table>
</div>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

</body>
</html>

