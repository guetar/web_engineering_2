package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Game;
import model.Player;

public class GameServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("restart") != null) {
            req.getSession(false).invalidate();
        }
            
        HttpSession session = req.getSession();
        Player p1 = (Player) session.getAttribute("p1");
        Player p2 = (Player) session.getAttribute("p2");
        Game game = (Game) session.getAttribute("game");
        
        p1 = (p1 == null) ? new Player("Super Mario") : p1;
        p2 = (p2 == null) ? new Player("Super C") : p2;
        game = (game == null) ? new Game(p1, p2) : game;
        
        game.incrementRound();
        
        if (req.getParameter("dice") != null) {
            p1.setDice((int)Math.floor(Math.random() * 3) + 1);
            p2.setDice((int)Math.floor(Math.random() * 3) + 1);
        }
        
        session.setAttribute("p1", p1);
        session.setAttribute("p2", p2);
        session.setAttribute("game", game);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/table.jsp");
        dispatcher.forward(req, resp);
    }
}
