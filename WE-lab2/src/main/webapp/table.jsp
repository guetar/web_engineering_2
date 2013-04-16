<?xml version="1.0" encoding="ISO-8859-1"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<%@ page import="model.Game" %>
<html xmlns="http://www.w3.org/1999/xhtml" lang="de" xml:lang="de">
    <head>
        <title xml:lang="de">Formel 0 - Spielen</title>
        <meta http-equiv="content-type" content="text/html; charset=ISO-8859-1" />
        <link rel="stylesheet" type="text/css" href="styles/screen.css" />
        <script src="js/jquery.js" type="text/javascript"></script>
        <jsp:useBean id="game" scope="session" class="Game"/>
    </head>
    <body>
        <div id="container">
            <div id="bordercontainer">
                <div id="header">
                    <div id="header_left"><h1 class="accessibility">Formel 0</h1></div>
                    <div id="header_right"></div>
                </div>
                <div id="navigation">
                    <h2 class="accessibility">Navigation</h2>
                    <ul title="Navigation">
                        <li><a id="startNewGame" href="#" tabindex="1">Neues Spiel</a></li>
                        <li><a href="#" tabindex="2">Ausloggen</a></li>
                    </ul>
                </div>
                <div id="main-area">
                    <div class="info">
                        <h2>Spielinformationen</h2>
                        <table summary="Diese Tabelle zeigt Informationen zum aktuellen Spiel">
                            <tr><th id="leaderLabel" class="label">F&uuml;hrender</th><td id="leader" class="data">todo</td></tr>
                            <tr><th id="roundLabel" class="label">Runde</th><td id="round" class="data"><%=game.getRound()%></td></tr>
                            <tr><th id="timeLabel" class="label">Zeit</th><td id="time" class="data">todo</td></tr>
                            <tr><th id="computerScoreLabel" class="label">W&uuml;rfelergebnis <em>Super C</em></th><td id="computerScore" class="data">todo</td></tr>
                        </table>  
                        <h2>Spieler</h2>
                        <table summary="Diese Tabelle listet die Namen der Spieler auf">
                            <tr><th id="player1NameLabel" class="label">Spieler 1</th><td id="player1Name" class="data"><%=game.getPlayer1Name()%></td></tr>
                            <tr><th id="player2NameLabel" class="label">Spieler 2</th><td id="player2Name" class="data"><%=game.getPlayer2Name()%></td></tr>
                        </table>    	  
                    </div>
                    <div class="field">
                        <h2 class="accessibility">Spielbereich</h2>
                        <ol id="road">
                            <li id="start_road">
                                <span class="accessibility">Startfeld</span>
                            </li>
                            <li class="empty_road" id="road_1">
                                <span class="accessibility">Feld 2</span>
                            </li>
                            <li class="oil_road" id="road_2">
                                <span class="accessibility">Feld 3</span>
                                <span id="player1">
                                    <span class="accessibility"><em>Spieler 1</em></span>
                                </span>
                            </li>
                            <li class="empty_road" id="road_3">
                                <span class="accessibility">Feld 4</span>
                            </li>
                            <li class="empty_road" id="road_4">
                                <span class="accessibility">Feld 5</span>
                                <span id="player2">
                                    <span class="accessibility"><em>Spieler 2</em></span>
                                </span>
                            </li>
                            <li class="oil_road" id="road_5">
                                <span class="accessibility">Feld 6</span>
                            </li>
                            <li id="finish_road">
                                <span class="accessibility">Zielfeld</span>
                            </li>
                        </ol>
                    </div>
                    <div class="player">
                        <h2 class="accessibility">W&uuml;rfelbereich</h2>
                        <span class="accessibility">An der Reihe ist</span><div id="currentPlayerName">Super Mario</div>
                        <a id="dice" href="GameServlet" tabindex="4">
                            <img id="diceImage" src="img/wuerfel1.png" alt="W&uuml;rfel mit einer Eins" />	
                        </a>
                    </div>
                </div>
            </div>
            <div id="footer">
                &copy; 2013 Formel 0
            </div>
        </div>
    </body>
</html>