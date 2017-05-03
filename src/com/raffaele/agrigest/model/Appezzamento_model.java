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
package com.raffaele.agrigest.model;

import com.raffaele.agrigest.AgriGest;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Raffaele Francesco Mancino
 */
public class Appezzamento_model extends Model
{
    private ArrayList<Appezzamento> list;
    
    public Appezzamento_model()
    {
        this.nome="appezzamento";
    }
    
    public void loadAll(int id)
    {
        String str="SELECT * FROM appezzamento WHERE appezzamento.idmasseria=" + id;
        this.list=new ArrayList<Appezzamento>();
        ResultSet rs=AgriGest.dbManager.query(str);
        if(rs!=null)
        {
            try {
                while(rs.next())
                {
                    Appezzamento a=new Appezzamento();
                    a.id=rs.getInt("id");
                    a.nome=rs.getString("nome");
                    a.dimensione=rs.getFloat("dimensione");
                    this.list.add(a);
                }                
            } catch (SQLException ex) {
                System.err.println(ex.toString());
            }
            super.sendChanges();
        }
    }
    
    public ArrayList<Appezzamento> getList()
    {
        return this.list;
    }
}
