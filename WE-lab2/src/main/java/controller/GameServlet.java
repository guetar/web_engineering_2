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
import model.Track;

public class GameServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("restart") != null) {
            req.getSession(false).invalidate();
        } else if (req.getParameter("dice") != null) {
            HttpSession session = req.getSession();
            Game game = (Game) session.getAttribute("game");

            if (game == null) {
                game = new Game();
            }
            
            update(game);

            session.setAttribute("game", game);
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/table.jsp");
        dispatcher.forward(req, resp);
    }
    
    public static void update(Game game) {
        Player p1 = game.getP1();
        Player p2 = game.getP2();
        Track track = game.getTrack();

        if (p1.getCurPos() == track.getLength() || p2.getCurPos() == track.getLength()) {
            game.setOver();
        }

        game.incrementRound();

        p1.setDice((int) Math.floor(Math.random() * 3) + 1);
        p2.setDice((int) Math.floor(Math.random() * 3) + 1);
        
        p1.setPos(p1.getCurPos() + p1.getDice());
        p2.setPos(p2.getCurPos() + p2.getDice());
        
        if (p1.getCurPos() > p2.getCurPos()) {
            game.setLeader(1);
        } else if (p1.getCurPos() < p2.getCurPos()) {
            game.setLeader(2);
        } else {
            game.setLeader(0);
        }
    }
}
