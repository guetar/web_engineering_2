package controller;

import model.Game;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GameServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("restart") != null) {
            req.getSession(false).invalidate();
        } else {
            HttpSession session = req.getSession();
            Game game = (Game) session.getAttribute("game");

            if (game == null) {
                game = new Game();
            }

            game.incrementRound();
            session.setAttribute("game", game);
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/table.jsp");
        dispatcher.forward(req, resp);
    }
}
