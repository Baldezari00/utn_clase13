package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/db1?serverTimezone=UTC";
        String username = "root";
        String password = "BaldeDB1qsefthukoñ12$7bdzr";



        try{
            Connection conn = DriverManager.getConnection(url,username,password);
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM departamento");
            int update1 = statement.executeUpdate("UPDATE `db1`.`empleado` SET `nacionalidad` = 'Alemana' WHERE (`dni` = '24789222');");
            int  update2 = statement.executeUpdate("INSERT INTO `db1`.`empleado` (`nombre`, `apellido`, `nacionalidad`, `departamento`, `dni`) VALUES ('Sofia', 'Baldes', 'Argentina', '1', '43326522');");
            int  update3 = statement.executeUpdate("INSERT INTO `db1`.`empleado` (`nombre`, `apellido`, `nacionalidad`, `departamento`, `dni`) VALUES ('Michelle', 'Goenaga', 'Argentina', '2', '49320029');");
            System.out.println("Cambio de nacionalidad, filas afectadas: "+update1);
            System.out.println("Nuevos empleados: "+ (update2+update3));

            while (rs.next()){
                System.out.println(rs.getString("nombre"));

            }
            conn.close();
            statement.close();
            rs.close();

        }catch (SQLException e){
            e.getMessage();
        }catch (Exception e){
            e.getMessage();
        }

    }
}