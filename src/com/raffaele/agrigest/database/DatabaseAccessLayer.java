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

import com.raffaele.agrigest.AgriGest;
import com.raffaele.agrigest.model.dao.Home;
import com.raffaele.agrigest.model.dao.Login;
import com.raffaele.agrigest.model.dao.Plot;
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
    
    public ArrayList<Login> selectMasseria()
    {
        String str="SELECT * FROM masseria ORDER BY masseria.id ASC";
        ArrayList<Login> list=new ArrayList<Login>();
        ResultSet rs=this.databaseManager.query(str);
        if(rs!=null)
        {
            try {
                while(rs.next())
                {
                    Login m=new Login();
                    m.id=rs.getInt("id");
                    m.name=rs.getString("nome");
                    list.add(m);
                }
            } catch (SQLException ex) {
                System.err.println(ex.toString());
            }
        }
        return list;
    }
    
    public ArrayList<Login> selectMasseriaByID(int id)
    {
        String str="SELECT * FROM masseria WHERE masseria.id=\"" + id + "\"";
        ArrayList<Login> list=new ArrayList<Login>();
        ResultSet rs=this.databaseManager.query(str);
        if(rs!=null)
        {
            try {
                while(rs.next())
                {
                    Login m=new Login();
                    m.id=rs.getInt("id");
                    m.name=rs.getString("nome");
                    list.add(m);
                }
            } catch (SQLException ex) {
                System.err.println(ex.toString());
            }
        }
        return list;
    }
    
    public ArrayList<Home> selectPlotWithCulture(int id)
    {
        String str="SELECT appezzamento.nome,appezzamento.dimensione,coltura.nome AS cnome FROM appezzamento LEFT JOIN (appezzamentocoltura JOIN coltura ON appezzamentocoltura.idcoltura=coltura.id) ON appezzamento.id=appezzamentocoltura.idappezzamento WHERE appezzamento.idmasseria=" + id;
        ArrayList<Home> list=new ArrayList<Home>();
        ResultSet rs=this.databaseManager.query(str);
        
        if(rs!=null)
        {
            try {
                Home a;
                while(rs.next())
                {
                    a=new Home();
                    a.namePlot=rs.getString("nome");
                    a.sizePlot=rs.getFloat("dimensione");
                    a.nameColture=rs.getString("cnome");
                    list.add(a);
                }
            } catch (SQLException ex) {
                System.err.println(ex.toString());
            }
        }
        return list;
    }
    
    public void insertPlot(String name, float size)
    {
        String str="INSERT INTO Appezzamento(nome,dimensione,idMasseria) VALUES(\""+name+"\", "+size+","+AgriGest.appController.masseriaID+")";
        this.databaseManager.insert(str);
    }
    
    public ArrayList<Plot> selectPlot()
    {
        String str="SELECT * FROM appezzamento WHERE idmasseria=" + AgriGest.appController.masseriaID;
        ArrayList<Plot> list=new ArrayList<Plot>();
        ResultSet rs=this.databaseManager.query(str);
        
        if(rs!=null)
        {
            try {
                Plot a;
                while(rs.next())
                {
                    a=new Plot();
                    a.idPlot=rs.getInt("id");
                    a.namePlot=rs.getString("nome");
                    a.sizePlot=rs.getFloat("dimensione");
                    list.add(a);
                }
            } catch (SQLException ex) {
                System.err.println(ex.toString());
            }
        }
        return list;
    }
    
    public ArrayList<Plot> selectPlotByName(String name)
    {
        String str="SELECT * FROM appezzamento WHERE nome=\""+name+"\"";
        ArrayList<Plot> list=new ArrayList<Plot>();
        ResultSet rs=this.databaseManager.query(str);
        
        if(rs!=null)
        {
            try {
                Plot a;
                while(rs.next())
                {
                    a=new Plot();
                    a.idPlot=rs.getInt("id");
                    a.namePlot=rs.getString("nome");
                    a.sizePlot=rs.getFloat("dimensione");
                    list.add(a);
                }
            } catch (SQLException ex) {
                System.err.println(ex.toString());
            }
        }
        return list;
    }
    
    public void deletePlot(int id)
    {
        String str="DELETE FROM appezzamento WHERE id="+id;
        this.databaseManager.insert(str);
    }
}
