package br.com.alura.bytebank;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {

    public  Connection recuperarConexao () {

        try {
            return createDataSource().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private HikariDataSource createDataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/byte_bank");
        config.setUsername("Nicolas");
        config.setPassword("M1SQLN1c0l@s05");
        config.setMaximumPoolSize(10);

        return new HikariDataSource(config);
    }

}
//Primeiro método de conexão
//    public static void main(String[] args) {
//
//        try {
//            Connection conecction = DriverManager
//                    .getConnection("jdbc:mysql://localhost:3306/byte_bank","Nicolas","M1SQLN1c0l@s05");
//
//            System.out.println("Conexão recuperada!");
//
//            conecction.close();
//        } catch (SQLException e) {
//            System.out.println("Erro ao conectar com o banco");
//        }
//
//    }

//Segundo método de conexão
//try {
//        return DriverManager.getConnection("jdbc:mysql://localhost:3306/byte_bank","Nicolas","M1SQLN1c0l@s05");
//        } catch (SQLException e) {
//        throw new RuntimeException(e);
//        }