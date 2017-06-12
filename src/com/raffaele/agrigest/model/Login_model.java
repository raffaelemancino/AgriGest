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

import com.raffaele.agrigest.model.dao.Login;
import com.raffaele.agrigest.AgriGest;
import java.util.ArrayList;

/**
 *
 * @author Raffaele Francesco Mancino
 */
public class Login_model extends Model
{
    {
        this.list=new ArrayList<Login>();
    }
    
    public void loadAll()
    {
        this.list=AgriGest.databaseAccessLayer.selectMasseria();
        super.sendChanges();
    }
    
    public Login getMasseria(int i)
    {
        return (Login)this.list.get(i);
    }
}
