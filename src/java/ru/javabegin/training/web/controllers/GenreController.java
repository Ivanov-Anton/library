package ru.javabegin.training.web.controllers;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import ru.javabegin.training.web.beans.Genre;
import ru.javabegin.training.web.db.Database;

@ManagedBean(eager = true)
@ApplicationScoped
public class GenreController implements Serializable {

    private ArrayList<Genre> genreList;

    public GenreController() {
        fillGenresAll();
    }

    private void fillGenresAll() {
        Statement stmt = null;
        ResultSet rs = null;
        Connection conn = null;

        genreList = new ArrayList<Genre>();

        try {
            conn = Database.getConnection();

            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from genre order by name");
            while (rs.next()) {
                Genre genre = new Genre();
                genre.setName(rs.getString("name"));
                genre.setId(rs.getLong("id"));
                genreList.add(genre);
            }

        } catch (SQLException ex) {
            Logger.getLogger(GenreController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(GenreController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public ArrayList<Genre> getGenreList() {
        return genreList;
    }
}
