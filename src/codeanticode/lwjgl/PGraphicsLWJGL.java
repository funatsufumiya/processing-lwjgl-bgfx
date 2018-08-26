/* -*- mode: java; c-basic-offset: 2; indent-tabs-mode: nil -*- */

/*
  Part of the Processing project - http://processing.org

  Copyright (c) 2012-15 The Processing Foundation
  Copyright (c) 2004-12 Ben Fry and Casey Reas
  Copyright (c) 2001-04 Massachusetts Institute of Technology

  This library is free software; you can redistribute it and/or
  modify it under the terms of the GNU Lesser General Public
  License as published by the Free Software Foundation, version 2.1.

  This library is distributed in the hope that it will be useful,
  but WITHOUT ANY WARRANTY; without even the implied warranty of
  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
  Lesser General Public License for more details.

  You should have received a copy of the GNU Lesser General
  Public License along with this library; if not, write to the
  Free Software Foundation, Inc., 59 Temple Place, Suite 330,
  Boston, MA  02111-1307  USA
*/

package codeanticode.lwjgl;

import processing.core.*;
import processing.opengl.*;

/**
 * OpenGL renderer.
 */
public class PGraphicsLWJGL extends PGraphicsOpenGL {
  
  public PGraphicsLWJGL() {
    super();
  }

  @Override
  public PSurface createSurface() {  // ignore
    return surface = new PSurfaceLWJGL(this);
  }
  
  protected PGL createPGL(PGraphicsOpenGL pg) {
    return new PLWJGL(pg);
  }  
  
  protected void setViewport() {
    viewport.put(0, 0); 
    viewport.put(1, 0);
    viewport.put(2, ((PSurfaceLWJGL)surface).fbWidth); 
    viewport.put(3, ((PSurfaceLWJGL)surface).fbHeight);
//    System.out.println("Viewport " + ((PSurfaceLWJGL)surface).fbWidth + "x" + ((PSurfaceLWJGL)surface).fbHeight);
    pgl.viewport(viewport.get(0), viewport.get(1),
                 viewport.get(2), viewport.get(3));
  }  
}
