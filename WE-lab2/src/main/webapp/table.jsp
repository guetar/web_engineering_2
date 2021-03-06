<%@page import="model.Game"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>

<?xml version="1.0" encoding="ISO-8859-1"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="de" xml:lang="de">
    <head>
        <title xml:lang="de">Formel 0 - Spielen</title>
        <meta http-equiv="content-type" content="text/html; charset=ISO-8859-1" />
        <link rel="stylesheet" type="text/css" href="styles/screen.css" />

        <jsp:useBean id='game' class="model.Game" scope="session"/>

        <script src="js/jquery.js" type="text/javascript"></script>
        <script type="text/javascript">
            //<![CDATA[

            // call this function once before starting the animations
            function prepareAnimation() {
                $("#animationDone").remove();
            }

            $(document).ready(function() {
                prepareAnimation();

                if (<%=game.getRound()%> > 0) {
                    $("#player1").appendTo(document.getElementById("<%=game.getP1().getOPos()%>"));
                    $("#player2").appendTo(document.getElementById("<%=game.getP2().getOPos()%>"));
                    
                    drawPlayer1NoOil();
                }
                
                completeAnimation();
                
                return false;
            });


            function drawPlayer1NoOil() {

                
                //Animation Player 1
                $("#player1").fadeOut(700, function() {
                    $("#player1").appendTo(document.getElementById("<%=game.getP1().getNPos()%>"));
                    $("#player1").fadeIn(700, drawPlayer1Oil);
                });
            }

            function drawPlayer1Oil() {
                if (<%=game.isOilField(game.getP1().getCurPos())%>) {
                    //Zurücksetzen auf den Start des Players 1
                    
                    $("#player1").fadeOut(700, function() {
                        $("#player1").appendTo(document.getElementById("start_road"));
                        $("#player1").fadeIn(700, drawPlayer2NoOil);
                    });

                } else {
                    drawPlayer2NoOil();
                }
            }

            function drawPlayer2NoOil() {

                if(<%=game.getP2().getDice()%>!=0) {
                    //Animation Player 2
                    $("#player2").fadeOut(700, function() {
                        $("#player2").appendTo(document.getElementById("<%=game.getP2().getNPos()%>"));
                        $("#player2").fadeIn(700, drawPlayer2Oil);
                    });
                } else {
                    completeAnimation;
                }
            }

            function drawPlayer2Oil() {
                if (<%=game.isOilField(game.getP2().getCurPos())%>) {
                    //Zurücksetzen auf den Start des Players 2
                   
                    $("#player2").fadeOut(700, function() {
                        $("#player2").appendTo(document.getElementById("start_road"));
                        $("#player2").fadeIn(700, completeAnimation);
                    });

                } else {
                    completeAnimation();
                }
            }

            // call this function once after all animations have finished
            function completeAnimation() {
                var div = $(document.createElement('div'));
                div.attr('id', 'animationDone');
                div.addClass('hide');
                $("body").append(div);
            }
            //]]>
        </script>
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
                        <li><a id="startNewGame" href="GameServlet?restart=true" tabindex="1">Neues Spiel</a></li>
                        <li><a href="#" tabindex="2">Ausloggen</a></li>
                    </ul>
                </div>
                <div id="main-area">
                    <div class="info">
                        <h2>Spielinformationen</h2>
                        <table summary="Diese Tabelle zeigt Informationen zum aktuellen Spiel">
                            <% String leaderName = game.getLeaderName().isEmpty() ? "mehrere" : game.getLeaderName();%>
                            <tr><th id="leaderLabel" class="label">F&uuml;hrender</th><td id="leader" class="data"><%=leaderName%></td></tr>
                            <tr><th id="roundLabel" class="label">Runde</th><td id="round" class="data"><%=game.getRound()%></td></tr>
                                    <% Date date = new Date(game.getElapsedTime());
                                        DateFormat formatter = new SimpleDateFormat("mm:ss");
                                        String timeString = formatter.format(date);%>
                            <tr><th id="timeLabel" class="label">Zeit</th><td id="time" class="data"><%=timeString%></td></tr>
                            <tr><th id="computerScoreLabel" class="label">W&uuml;rfelergebnis <em>Super C</em></th><td id="computerScore" class="data"><%=game.getP2().getDice()%></td></tr>
                        </table>  
                        <h2>Spieler</h2>
                        <table summary="Diese Tabelle listet die Namen der Spieler auf">
                            <tr><th id="player1NameLabel" class="label">Spieler 1</th><td id="player1Name" class="data"><%=game.getP1().getName()%></td></tr>
                            <tr><th id="player2NameLabel" class="label">Spieler 2</th><td id="player2Name" class="data"><%=game.getP2().getName()%></td></tr>
                        </table>    	  
                    </div>
                    <div class="field">
                        <h2 class="accessibility">Spielbereich</h2>
                        <ol id="road">
                            <li id="start_road">
                                <span class="accessibility">Startfeld</span>
                                <span id="player1">
                                    <span class="accessibility"><em>Spieler 1</em></span>
                                </span>
                                <span id="player2">
                                    <span class="accessibility"><em>Spieler 2</em></span>
                                </span>
                            </li>
                            <li class="empty_road" id="road_1">
                                <span class="accessibility">Feld 2</span>
                            </li>
                            <li class="oil_road" id="road_2">
                                <span class="accessibility">Feld 3</span>

                            </li>
                            <li class="empty_road" id="road_3">
                                <span class="accessibility">Feld 4</span>
                            </li>
                            <li class="empty_road" id="road_4">
                                <span class="accessibility">Feld 5</span>

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
                        <%
                            String linkString ="#";
                            if(game.isOver() == false) {
                                linkString="GameServlet?dice=true";
                            }
                        %>
                        <a id="dice" href="<%=linkString%>" tabindex="4">
                            <img id="diceImage" src="img/wuerfel<%=game.getP1().getDice()%>.png" alt="Würfel mit einer Eins" />	
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
