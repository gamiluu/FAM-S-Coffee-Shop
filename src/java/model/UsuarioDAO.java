package model;

import java.sql.ResultSet;
import java.util.ArrayList;

public class UsuarioDAO implements DAO<Usuario, Integer> {

    private static final String SQL_FIND_ALL = "SELECT  *  FROM usuario WHERE 1=1 ";
    private MotorSQL motorSql;

    public UsuarioDAO() {
        this.motorSql = new MotorSQL();
    }
    
    @Override
    public int add(Usuario entity) {
        return 0;
    }

    @Override
    public int delete(Integer e) {
        return 0;
    }

    @Override
    public int update(Usuario entity) {
        return 0;
    }

    @Override
    public ArrayList<Usuario> findAll(Usuario entity) {
        ArrayList<Usuario> lstUsuarios = new ArrayList<>();
        try {
            this.motorSql.connect();
            String sqlCabecera = SQL_FIND_ALL;
            String sqlCuerpo = "";
            if (entity != null) {
                if (entity.getId() > 0) {
                    sqlCuerpo = " AND ID_USUARIO=" + entity.getId();
                }
                if (entity.getUsername() != null && !entity.getUsername().equals("")) {
                    sqlCuerpo = " AND USERNAME='" + entity.getUsername() + "'";
                }
                if (entity.getPassword() != null && !entity.getPassword().equals("")) {
                    sqlCuerpo += " AND PASS='" + entity.getPassword() + "'";
                }

            }

            String sqlFinal = sqlCabecera + sqlCuerpo;
            ResultSet rs = this.motorSql.executeQuery(sqlFinal);

            rs.beforeFirst();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt(1));
                usuario.setUsername(rs.getString(2));
                usuario.setPassword(rs.getString(3));
                lstUsuarios.add(usuario);
            }
        } catch (Exception ex) {

        } finally {
            this.motorSql.disconnect();
        }

        return lstUsuarios;
    }
    
}
