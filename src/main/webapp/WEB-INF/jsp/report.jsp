<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="en">
    <head>
        <!-- Head -->
        <%@include file="include/head.jspf"  %>
    </head>
    <body>

        <div id="layout">
            <!-- Toggle -->
            <%@include file="include/toggle.jspf"  %>

            <!-- Menu -->
            <%@include file="include/menu.jspf"  %>

            <div id="main">
                <div class="header">
                    <h1>Report</h1>
                    <h2>報表分析</h2>
                </div>
            </div>

            <div class="information pure-g">
                <div class="pure-u-1 pure-u-md-1-2">
                    <div class="l-box">
                        <div class="content">
                            <form class="pure-form">
                                <fieldset>
                                    <legend><h2 class="content-subhead">顧客消費-金額</h2></legend>
                                    <table class="pure-table pure-table-bordered">
                                        <thead>
                                            <tr>
                                                <th nowrap>Id</th>
                                                <th nowrap>Name</th>
                                                <th nowrap>subtotal</th>
                                            </tr>
                                        </thead>

                                        <tbody>
                                            <c:forEach var="item" items="${list_customers}">
                                                <tr>
                                                    <td nowrap>${item.customerId}</td>
                                                    <td nowrap>${item.customerName}</td>
                                                    <td nowrap align="right">${item.subtotal}</td>
                                                </tr>
                                            </c:forEach>    
                                        </tbody>
                                    </table>
                                </fieldset>
                            </form>
                        </div>
                    </div>
                </div>

                <div class="pure-u-1 pure-u-md-1-2">
                    <div class="l-box">
                        <div class="content">
                            <form class="pure-form">
                                <fieldset>
                                    <legend><h2 class="content-subhead">商品銷售-數量</h2></legend>
                                    <table class="pure-table pure-table-bordered">
                                        <thead>
                                            <tr>
                                                <th nowrap>Id</th>
                                                <th nowrap>Name</th>
                                                <th nowrap>CodeName</th>
                                                <th nowrap>quantity</th>
                                            </tr>
                                        </thead>

                                        <tbody>
                                            <c:forEach var="item" items="${list_products}">
                                                <tr>
                                                    <td nowrap>${item.productId}</td>
                                                    <td nowrap>${item.productName}</td>
                                                    <td nowrap>${item.productCodeName}</td>
                                                    <td nowrap align="right">${item.quantity}</td>
                                                </tr>
                                            </c:forEach>    
                                        </tbody>
                                    </table>
                                </fieldset>
                            </form>
                        </div>
                    </div>
                </div>
                <!-- end information -->
            </div>

            <!-- Foot -->
            <%@include file="include/foot.jspf"  %>
        </div>
    </body>
</html>