package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Game;

public class GameServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("restart") != null) {
            req.getSession(false).invalidate();
        }
            
        HttpSession session = req.getSession();
        Game game = (Game) session.getAttribute("game");
        game = (game == null) ? new Game() : game;
        game.incrementRound();
        
        if (req.getParameter("dice") != null) {
            game.setDiceP1((int)Math.floor(Math.random() * 3) + 1);
            game.setDiceP2((int)Math.floor(Math.random() * 3) + 1);
        }
        
        session.setAttribute("game", game);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/table.jsp");
        dispatcher.forward(req, resp);
    }
}
