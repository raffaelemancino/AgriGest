/* 
 * Copyright (C) 2017 Raffaele Francesco Mancino
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package com.raffaele.agrigest.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Raffaele Francesco Mancino
 */
public class SqlServer implements IDatabase
{
    Connection connection;
    Statement statement;

    @Override
    public boolean connect(String path) {
        String url="jdbc:sqlite:" + path;
        try {
            this.connection=DriverManager.getConnection(url);
            this.statement=this.connection.createStatement();
            return true;
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            return false;
        }
    }

    @Override
    public ResultSet query(String str) {
        try {
            return this.statement.executeQuery(str);
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            return null;
        }
    }

    @Override
    public void insert(String str) {
        try {
            this.statement.executeUpdate(str);
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }
}
