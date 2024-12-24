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

import processing.core.PSurface;
import processing.opengl.PGL;
import processing.opengl.PGraphicsOpenGL;

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

  @Override
  public void beginDraw() {
    super.beginDraw();
  }

  @Override
  public void endDraw() {
    super.endDraw();
  }

  @Override
  protected void getGLParameters() {
    // Currently, just do nothing for BGFX
    // but set basical parameters
    // TODO: implement this method for BGFX

    OPENGL_VENDOR = "BGFX";
    OPENGL_RENDERER = "BGFX";
    OPENGL_VERSION = "3.3";
    OPENGL_EXTENSIONS = "";
    GLSL_VERSION = "1.50";
    
    npotTexSupported = true;
    autoMipmapGenSupported = true;
    fboMultisampleSupported = true;
    packedDepthStencilSupported = true;
    anisoSamplingSupported = true;
    readBufferSupported = true;
    drawBufferSupported = true;
    blendEqSupported = true;

    depthBits = 24;
    stencilBits = 8;

    maxTextureSize = 4096;
    maxSamples = 4;
    if (anisoSamplingSupported) {
      maxAnisoAmount = 16;
    }

    glParamsRead = true;
  }
}
