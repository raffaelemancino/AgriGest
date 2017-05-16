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

import com.raffaele.agrigest.model.AppezzamentoColtura;
import com.raffaele.agrigest.model.Masseria;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Raffaele Francesco Mancino
 */
public class DatabaseAccessLayer
{
    private DatabaseManager databaseManager=new DatabaseManager(DBList.SQLite);
    
    public DatabaseAccessLayer()
    {
        this.databaseManager.connect("Agrigest.db");
    }
    
    public ArrayList<Masseria> selectMasseria()
    {
        String str="SELECT * FROM masseria ORDER BY masseria.id ASC";
        ArrayList<Masseria> list=new ArrayList<Masseria>();
        ResultSet rs=this.databaseManager.query(str);
        if(rs!=null)
        {
            try {
                while(rs.next())
                {
                    Masseria m=new Masseria();
                    m.id=rs.getInt("id");
                    m.nome=rs.getString("nome");
                    list.add(m);
                }
            } catch (SQLException ex) {
                System.err.println(ex.toString());
            }
        }
        return list;
    }
    
    public ArrayList<Masseria> selectMasseriaByName(String nome)
    {
        String str="SELECT * FROM masseria WHERE masseria.nome=\"" + nome + "\"";
        ArrayList<Masseria> list=new ArrayList<Masseria>();
        ResultSet rs=this.databaseManager.query(str);
        if(rs!=null)
        {
            try {
                while(rs.next())
                {
                    Masseria m=new Masseria();
                    m.id=rs.getInt("id");
                    m.nome=rs.getString("nome");
                    list.add(m);
                }
                return list;
            } catch (SQLException ex) {
                System.err.println(ex.toString());
            }
        }
        return null;
    }
    
    public ArrayList<AppezzamentoColtura> selectAppezzamentoWithColtura(int id)
    {
        String str="SELECT appezzamento.nome,appezzamento.dimensione, coltura.nome FROM appezzamento JOIN (appezzamentocoltura JOIN coltura ON appezzamentocoltura.idcoltura=coltura.id) ON appezzamento.id=appezzamentocoltura.idappezzamento WHERE appezzamento.idmasseria=" + id;
        ArrayList<AppezzamentoColtura> list=new ArrayList<AppezzamentoColtura>();
        ResultSet rs=this.databaseManager.query(str);
        if(rs!=null)
        {
            try {
                while(rs.next())
                {
                    AppezzamentoColtura a=new AppezzamentoColtura();
                    a.nomeColtura=rs.getString("coltura.nome");
                    a.nomeAppezzamento=rs.getString("appezzamento.nome");
                    a.dimensione=rs.getFloat("appezzamento.dimensione");
                    list.add(a);
                }
                return list;
            } catch (SQLException ex) {
                System.err.println(ex.toString());
            }
        }
        return null;
    }
}
