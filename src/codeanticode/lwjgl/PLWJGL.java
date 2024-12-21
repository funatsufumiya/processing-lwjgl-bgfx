/* -*- mode: java; c-basic-offset: 2; indent-tabs-mode: nil -*- */

/*
  Part of the Processing project - http://processing.org

  Copyright (c) 2018 Andres Colubri

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

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.PathIterator;
import java.io.IOException;
import java.net.URL;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.NotImplementedException;
import org.lwjgl.BufferUtils;

import static codeanticode.lwjgl.internal.DummyGLConstants.EXTFramebufferObject_GL_FRAMEBUFFER_INCOMPLETE_DIMENSIONS_EXT;
import static codeanticode.lwjgl.internal.DummyGLConstants.EXTFramebufferObject_GL_FRAMEBUFFER_INCOMPLETE_FORMATS_EXT;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL21_GL_ALIASED_POINT_SIZE_RANGE;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL21_GL_ALPHA8;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL21_GL_DEPTH_BITS;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL21_GL_GENERATE_MIPMAP_HINT;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL21_GL_LUMINANCE;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL21_GL_LUMINANCE_ALPHA;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL21_GL_STENCIL_BITS;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL32C_GL_FRAMEBUFFER_INCOMPLETE_LAYER_TARGETS;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL32C_GL_TEXTURE_BINDING_RECTANGLE;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL32C_GL_TEXTURE_RECTANGLE;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_ALIASED_LINE_WIDTH_RANGE;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_ALPHA;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_ALREADY_SIGNALED;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_ALWAYS;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_ARRAY_BUFFER;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_BACK;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_BLEND;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_BOOL;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_BOOL_VEC2;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_BOOL_VEC3;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_BOOL_VEC4;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_BUFFER_SIZE;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_BUFFER_USAGE;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_BYTE;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_CCW;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_CLAMP_TO_EDGE;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_COLOR_ATTACHMENT0;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_COLOR_ATTACHMENT1;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_COLOR_ATTACHMENT2;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_COLOR_ATTACHMENT3;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_COLOR_BUFFER_BIT;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_COMPILE_STATUS;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_COMPRESSED_TEXTURE_FORMATS;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_CONDITION_SATISFIED;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_CONSTANT_ALPHA;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_CONSTANT_COLOR;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_CULL_FACE;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_CURRENT_VERTEX_ATTRIB;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_CW;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_DECR;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_DECR_WRAP;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_DELETE_STATUS;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_DEPTH24_STENCIL8;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_DEPTH_ATTACHMENT;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_DEPTH_BUFFER_BIT;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_DEPTH_COMPONENT;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_DEPTH_COMPONENT16;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_DEPTH_COMPONENT24;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_DEPTH_COMPONENT32;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_DEPTH_STENCIL;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_DEPTH_TEST;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_DEPTH_WRITEMASK;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_DITHER;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_DONT_CARE;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_DRAW_FRAMEBUFFER;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_DST_ALPHA;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_DST_COLOR;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_DYNAMIC_DRAW;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_ELEMENT_ARRAY_BUFFER;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_EQUAL;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_EXTENSIONS;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_FALSE;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_FASTEST;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_FLOAT;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_FLOAT_MAT2;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_FLOAT_MAT3;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_FLOAT_MAT4;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_FLOAT_VEC2;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_FLOAT_VEC3;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_FLOAT_VEC4;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_FRAGMENT_SHADER;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_FRAMEBUFFER;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_FRAMEBUFFER_ATTACHMENT_OBJECT_NAME;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_CUBE_MAP_FACE;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_FRAMEBUFFER_COMPLETE;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_FRAMEBUFFER_INCOMPLETE_DRAW_BUFFER;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_FRAMEBUFFER_INCOMPLETE_MULTISAMPLE;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_FRAMEBUFFER_INCOMPLETE_READ_BUFFER;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_FRAMEBUFFER_UNDEFINED;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_FRAMEBUFFER_UNSUPPORTED;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_FRONT;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_FRONT_AND_BACK;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_FUNC_ADD;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_FUNC_REVERSE_SUBTRACT;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_FUNC_SUBTRACT;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_GEQUAL;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_GREATER;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_HIGH_FLOAT;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_HIGH_INT;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_INCR;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_INCR_WRAP;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_INFO_LOG_LENGTH;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_INT;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_INT_VEC2;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_INT_VEC3;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_INT_VEC4;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_INVERT;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_KEEP;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_LEQUAL;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_LESS;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_LINEAR;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_LINEAR_MIPMAP_LINEAR;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_LINEAR_MIPMAP_NEAREST;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_LINES;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_LINE_LOOP;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_LINE_SMOOTH;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_LINE_STRIP;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_LINK_STATUS;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_LOW_FLOAT;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_LOW_INT;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_MAX;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_MAX_COMBINED_TEXTURE_IMAGE_UNITS;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_MAX_SAMPLES;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_MAX_TEXTURE_IMAGE_UNITS;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_MAX_TEXTURE_MAX_ANISOTROPY;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_MAX_TEXTURE_SIZE;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_MAX_VERTEX_ATTRIBS;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_MAX_VERTEX_TEXTURE_IMAGE_UNITS;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_MEDIUM_FLOAT;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_MEDIUM_INT;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_MIN;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_MULTISAMPLE;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_NEAREST;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_NEVER;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_NICEST;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_NOTEQUAL;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_NUM_COMPRESSED_TEXTURE_FORMATS;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_ONE;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_ONE_MINUS_CONSTANT_ALPHA;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_ONE_MINUS_CONSTANT_COLOR;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_ONE_MINUS_DST_COLOR;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_ONE_MINUS_SRC_ALPHA;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_ONE_MINUS_SRC_COLOR;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_PACK_ALIGNMENT;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_PIXEL_PACK_BUFFER;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_POINTS;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_POLYGON_OFFSET_FILL;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_POLYGON_SMOOTH;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_READ_FRAMEBUFFER;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_READ_ONLY;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_READ_WRITE;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_RENDERBUFFER;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_RENDERBUFFER_ALPHA_SIZE;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_RENDERBUFFER_BLUE_SIZE;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_RENDERBUFFER_DEPTH_SIZE;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_RENDERBUFFER_GREEN_SIZE;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_RENDERBUFFER_HEIGHT;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_RENDERBUFFER_INTERNAL_FORMAT;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_RENDERBUFFER_RED_SIZE;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_RENDERBUFFER_STENCIL_SIZE;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_RENDERBUFFER_WIDTH;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_RENDERER;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_REPEAT;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_REPLACE;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_RGB;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_RGB565;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_RGB5_A1;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_RGB8;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_RGBA;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_RGBA4;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_RGBA8;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_SAMPLER_2D;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_SAMPLER_CUBE;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_SAMPLES;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_SAMPLE_ALPHA_TO_COVERAGE;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_SAMPLE_COVERAGE;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_SCISSOR_TEST;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_SHADER_SOURCE_LENGTH;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_SHADER_TYPE;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_SHADING_LANGUAGE_VERSION;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_SHORT;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_SRC_ALPHA;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_SRC_ALPHA_SATURATE;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_SRC_COLOR;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_STATIC_DRAW;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_STENCIL_ATTACHMENT;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_STENCIL_BUFFER_BIT;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_STENCIL_INDEX;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_STENCIL_INDEX1;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_STENCIL_INDEX4;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_STENCIL_INDEX8;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_STENCIL_TEST;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_STREAM_DRAW;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_STREAM_READ;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_SYNC_GPU_COMMANDS_COMPLETE;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_TEXTURE0;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_TEXTURE1;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_TEXTURE2;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_TEXTURE3;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_TEXTURE_2D;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_TEXTURE_BINDING_2D;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_TEXTURE_CUBE_MAP;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_TEXTURE_CUBE_MAP_NEGATIVE_X;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_TEXTURE_CUBE_MAP_NEGATIVE_Y;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_TEXTURE_CUBE_MAP_NEGATIVE_Z;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_TEXTURE_CUBE_MAP_POSITIVE_X;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_TEXTURE_CUBE_MAP_POSITIVE_Y;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_TEXTURE_CUBE_MAP_POSITIVE_Z;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_TEXTURE_MAG_FILTER;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_TEXTURE_MAX_ANISOTROPY;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_TEXTURE_MIN_FILTER;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_TEXTURE_WRAP_R;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_TEXTURE_WRAP_S;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_TEXTURE_WRAP_T;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_TRIANGLES;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_TRIANGLE_FAN;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_TRIANGLE_STRIP;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_TRUE;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_UNPACK_ALIGNMENT;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_UNSIGNED_BYTE;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_UNSIGNED_INT;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_UNSIGNED_SHORT;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_UNSIGNED_SHORT_4_4_4_4;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_UNSIGNED_SHORT_5_5_5_1;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_UNSIGNED_SHORT_5_6_5;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_VALIDATE_STATUS;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_VENDOR;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_VERSION;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_VERTEX_ATTRIB_ARRAY_BUFFER_BINDING;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_VERTEX_ATTRIB_ARRAY_ENABLED;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_VERTEX_ATTRIB_ARRAY_NORMALIZED;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_VERTEX_ATTRIB_ARRAY_POINTER;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_VERTEX_ATTRIB_ARRAY_SIZE;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_VERTEX_ATTRIB_ARRAY_STRIDE;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_VERTEX_ATTRIB_ARRAY_TYPE;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_VERTEX_SHADER;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_VIEWPORT;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_WRITE_ONLY;
import static codeanticode.lwjgl.internal.DummyGLConstants.GL_ZERO;
import codeanticode.lwjgl.internal.DummyGLConstantsNames;
import codeanticode.lwjgl.tess.PGLU;
import codeanticode.lwjgl.tess.PGLUtessellator;
import codeanticode.lwjgl.tess.PGLUtessellatorCallbackAdapter;
import processing.core.PApplet;
import processing.core.PGraphics;
import processing.opengl.PGL;
import processing.opengl.PGraphicsOpenGL;

/**
 * Processing-OpenGL abstraction layer. LWJGL implementation.
 *
 * Some issues:
 * http://lwjgl.org/forum/index.php/topic,4711.0.html
 * http://www.java-gaming.org/topics/cannot-add-mouselistener-to-java-awt-canvas-with-lwjgl-on-windows/24650/view.html
 *
 */
public class PLWJGL extends PGL {
  
  static public final String P2D = "codeanticode.lwjgl.PGraphicsLWJGL2D";
  static public final String P3D = "codeanticode.lwjgl.PGraphicsLWJGL3D";  
  
  // ........................................................

  // Public members to access the underlying GL objects and canvas

  /** GLU interface **/
  public PGLU glu;

  // ........................................................

  // Utility buffers to copy projection/modelview matrices to GL

  protected FloatBuffer projMatrix;
  protected FloatBuffer mvMatrix;

  // ........................................................

  // Static initialization for some parameters that need to be different for
  // LWJGL

  static {
    MIN_DIRECT_BUFFER_SIZE = 16;
    INDEX_TYPE             = GL_UNSIGNED_SHORT;
  }

  ///////////////////////////////////////////////////////////

  // Initialization, finalization


  public PLWJGL(PGraphicsOpenGL pg) {
    super(pg);
    glu = new PGLU();
  }

  @Override
  protected boolean hasFBOs() {
    // return GL.getCapabilities().GL_ARB_framebuffer_object;
    throw new NotImplementedException("hasFBOs() unimplemented for BGFX");
    // return false;
  }

  @Override
  protected boolean hasShaders() {
    // // It is enough to check GL_ARB_shading_language_100 because it depends on
    // // ARB_shader_objects, ARB_fragment_shader and ARB_vertex_shader.
    // return GL.getCapabilities().GL_ARB_shading_language_100;
    throw new NotImplementedException("hasShaders() unimplemented for BGFX");
    // return false;
  }

  @Override
  protected boolean hasNpotTexSupport() {
    // return GL.getCapabilities().GL_ARB_texture_non_power_of_two;
    throw new NotImplementedException("hasNpotTexSupport() unimplemented for BGFX");
  }

  @Override
  protected boolean hasAutoMipmapGenSupport() {
    // return GL.getCapabilities().glGenerateMipmap != 0;
    throw new NotImplementedException("hasAutoMipmapGenSupport() unimplemented for BGFX");
  }

  @Override
  protected boolean hasFboMultisampleSupport() {
    // return GL.getCapabilities().GL_ARB_framebuffer_object;
    throw new NotImplementedException("hasFboMultisampleSupport() unimplemented for BGFX");
  }

  @Override
  protected boolean hasPackedDepthStencilSupport() {
    // return GL.getCapabilities().GL_ARB_framebuffer_object;
    throw new NotImplementedException("hasPackedDepthStencilSupport() unimplemented for BGFX");
  }

  @Override
  protected boolean hasAnisoSamplingSupport() {
    // return GL.getCapabilities().GL_ARB_texture_filter_anisotropic;
    throw new NotImplementedException("hasAnisoSamplingSupport() unimplemented for BGFX");
  }


  ///////////////////////////////////////////////////////////

  // Frame rendering


//  protected boolean canDraw() {
//    return pg.initialized && pg.parent.isDisplayable();
//  }
//

//  protected void requestFocus() { }


//  protected void requestDraw() {
//    if (pg.initialized) {
//      glThread = Thread.currentThread();
//      pg.parent.handleDraw();
//      Display.update();
//    }
//  }
//
//
//  protected void swapBuffers() {
//    try {
//      Display.swapBuffers();
//    } catch (LWJGLException e) {
//      e.printStackTrace();
//    }
//  }


  @Override
  protected void beginGL() {
    // // TODO: Content of this whole method is arcane and needs to go [jv 2018-11-07]
    // if (projMatrix == null) {
    //   projMatrix = allocateFloatBuffer(16);
    // }
    // GL21.glMatrixMode(GL21.GL_PROJECTION);
    // projMatrix.rewind();
    // projMatrix.put(graphics.projection.m00);
    // projMatrix.put(graphics.projection.m10);
    // projMatrix.put(graphics.projection.m20);
    // projMatrix.put(graphics.projection.m30);
    // projMatrix.put(graphics.projection.m01);
    // projMatrix.put(graphics.projection.m11);
    // projMatrix.put(graphics.projection.m21);
    // projMatrix.put(graphics.projection.m31);
    // projMatrix.put(graphics.projection.m02);
    // projMatrix.put(graphics.projection.m12);
    // projMatrix.put(graphics.projection.m22);
    // projMatrix.put(graphics.projection.m32);
    // projMatrix.put(graphics.projection.m03);
    // projMatrix.put(graphics.projection.m13);
    // projMatrix.put(graphics.projection.m23);
    // projMatrix.put(graphics.projection.m33);
    // projMatrix.rewind();
    // GL21.glLoadMatrixf(projMatrix);

    // if (mvMatrix == null) {
    //   mvMatrix = allocateFloatBuffer(16);
    // }
    // GL21.glMatrixMode(GL21.GL_MODELVIEW);
    // mvMatrix.rewind();
    // mvMatrix.put(graphics.modelview.m00);
    // mvMatrix.put(graphics.modelview.m10);
    // mvMatrix.put(graphics.modelview.m20);
    // mvMatrix.put(graphics.modelview.m30);
    // mvMatrix.put(graphics.modelview.m01);
    // mvMatrix.put(graphics.modelview.m11);
    // mvMatrix.put(graphics.modelview.m21);
    // mvMatrix.put(graphics.modelview.m31);
    // mvMatrix.put(graphics.modelview.m02);
    // mvMatrix.put(graphics.modelview.m12);
    // mvMatrix.put(graphics.modelview.m22);
    // mvMatrix.put(graphics.modelview.m32);
    // mvMatrix.put(graphics.modelview.m03);
    // mvMatrix.put(graphics.modelview.m13);
    // mvMatrix.put(graphics.modelview.m23);
    // mvMatrix.put(graphics.modelview.m33);
    // mvMatrix.rewind();
    // GL21.glLoadMatrixf(mvMatrix);

    throw new NotImplementedException("beginGL() unimplemented for BGFX");
  }


  ///////////////////////////////////////////////////////////

  // Utility functions

  // TODO: These don't overload methods from PGL with the same names, buffer
  //       handling should be reworked globally, in the best case we can change
  //       most of the buffers to stack allocation [jv 2018-11-05]
  //       See: https://blog.lwjgl.org/memory-management-in-lwjgl-3/

  protected static ByteBuffer allocateDirectByteBuffer(int size) {
    return BufferUtils.createByteBuffer(size);
  }


  protected static ShortBuffer allocateDirectShortBuffer(int size) {
    return BufferUtils.createShortBuffer(size);
  }


  protected static IntBuffer allocateDirectIntBuffer(int size) {
    return BufferUtils.createIntBuffer(size);
  }


  protected static FloatBuffer allocateDirectFloatBuffer(int size) {
    return BufferUtils.createFloatBuffer(size);
  }


  /**
   * Convenience method to get a legit FontMetrics object. Where possible,
   * override this any renderer subclass so that you're not using what's
   * returned by getDefaultToolkit() to get your metrics.
   */
  @SuppressWarnings("deprecation")
  private FontMetrics getFontMetrics(Font font) {  // ignore
    return Toolkit.getDefaultToolkit().getFontMetrics(font);
  }


  /**
   * Convenience method to jump through some Java2D hoops and get an FRC.
   */
  private FontRenderContext getFontRenderContext(Font font) {  // ignore
    return getFontMetrics(font).getFontRenderContext();
  }



  // @Override
  // protected int getFontAscent(Object font) {
  //   return getFontMetrics((Font) font).getAscent();
  // }


  // @Override
  // protected int getFontDescent(Object font) {
  //   return getFontMetrics((Font) font).getDescent();
  // }


  @Override
  protected int getTextWidth(Object font, char buffer[], int start, int stop) {
    // maybe should use one of the newer/fancier functions for this?
    int length = stop - start;
    FontMetrics metrics = getFontMetrics((Font) font);
    return metrics.charsWidth(buffer, start, length);
  }


  @Override
  protected Object getDerivedFont(Object font, float size) {
    return ((Font) font).deriveFont(size);
  }


  ///////////////////////////////////////////////////////////
  ///////////////////////////////////////////////////////////

  // Tessellator interface


  @Override
  protected Tessellator createTessellator(TessellatorCallback callback) {
    return new Tessellator(callback);
  }


  protected class Tessellator implements PGL.Tessellator {
    protected PGLUtessellator tess;
    protected TessellatorCallback callback;
    protected GLUCallback gluCallback;

    public Tessellator(TessellatorCallback callback) {
      this.callback = callback;
      tess = PGLU.gluNewTess();
      gluCallback = new GLUCallback();

      PGLU.gluTessCallback(tess, PGLU.GLU_TESS_BEGIN, gluCallback);
      PGLU.gluTessCallback(tess, PGLU.GLU_TESS_END, gluCallback);
      PGLU.gluTessCallback(tess, PGLU.GLU_TESS_VERTEX, gluCallback);
      PGLU.gluTessCallback(tess, PGLU.GLU_TESS_COMBINE, gluCallback);
      PGLU.gluTessCallback(tess, PGLU.GLU_TESS_ERROR, gluCallback);
    }

    public void setCallback(int flag) {
      PGLU.gluTessCallback(tess, flag, gluCallback);      
    }    
    
    public void setWindingRule(int rule) {
      PGLU.gluTessProperty(tess, PGLU.GLU_TESS_WINDING_RULE, rule);
    }    
    
    public void setProperty(int property, int value) {
      PGLU.gluTessProperty(tess, property, value);      
    } 
    
    public void beginPolygon() {
      PGLU.gluTessBeginPolygon(tess, null);
    }

    public void beginPolygon(Object data) {
      PGLU.gluTessBeginPolygon(tess, data);      
    }    
    
    public void endPolygon() {
      PGLU.gluTessEndPolygon(tess);
    }

    public void beginContour() {
      PGLU.gluTessBeginContour(tess);
    }

    public void endContour() {
      PGLU.gluTessEndContour(tess);
    }

    public void addVertex(double[] v) {
      PGLU.gluTessVertex(tess, v, 0, v);
    }

    public void addVertex(double[] v, int n, Object data) {
      PGLU.gluTessVertex(tess, v, n, data);      
    }    

    protected class GLUCallback extends PGLUtessellatorCallbackAdapter {
      @Override
      public void begin(int type) {
        callback.begin(type);
      }

      @Override
      public void end() {
        callback.end();
      }

      @Override
      public void vertex(Object data) {
        callback.vertex(data);
      }

      @Override
      public void combine(double[] coords, Object[] data,
                          float[] weight, Object[] outData) {
        callback.combine(coords, data, weight, outData);
      }

      @Override
      public void error(int errnum) {
        callback.error(errnum);
      }
    }
  }


  @Override
  protected String tessError(int err) {
    return PGLU.gluErrorString(err);
  }



  ///////////////////////////////////////////////////////////

  // Font outline


  static {
    SHAPE_TEXT_SUPPORTED = true;
    SEG_MOVETO  = PathIterator.SEG_MOVETO;
    SEG_LINETO  = PathIterator.SEG_LINETO;
    SEG_QUADTO  = PathIterator.SEG_QUADTO;
    SEG_CUBICTO = PathIterator.SEG_CUBICTO;
    SEG_CLOSE   = PathIterator.SEG_CLOSE;
  }


  @Override
  protected FontOutline createFontOutline(char ch, Object font) {
    return new FontOutline(ch, (Font) font);
  }


  protected class FontOutline implements PGL.FontOutline {
    PathIterator iter;

    public FontOutline(char ch, Font font) {
      char textArray[] = new char[] { ch };
      FontRenderContext frc = getFontRenderContext(font);
      GlyphVector gv = font.createGlyphVector(frc, textArray);
      Shape shp = gv.getOutline();
      iter = shp.getPathIterator(null);
    }

    public boolean isDone() {
      return iter.isDone();
    }

    public int currentSegment(float coords[]) {
      return iter.currentSegment(coords);
    }

    public void next() {
      iter.next();
    }
  }


  ///////////////////////////////////////////////////////////

  // Constants

  static {
    FALSE = GL_FALSE;
    TRUE = GL_TRUE;

    INT = GL_INT;
    BYTE = GL_BYTE;
    SHORT = GL_SHORT;
    FLOAT = GL_FLOAT;
    BOOL = GL_BOOL;
    UNSIGNED_INT = GL_UNSIGNED_INT;
    UNSIGNED_BYTE = GL_UNSIGNED_BYTE;
    UNSIGNED_SHORT = GL_UNSIGNED_SHORT;

    RGB = GL_RGB;
    RGBA = GL_RGBA;
    ALPHA = GL_ALPHA;
    LUMINANCE = GL21_GL_LUMINANCE; // TODO: not used, not core, remove
    LUMINANCE_ALPHA = GL21_GL_LUMINANCE_ALPHA; // TODO: not used, not core, remove

    UNSIGNED_SHORT_5_6_5 = GL_UNSIGNED_SHORT_5_6_5;
    UNSIGNED_SHORT_4_4_4_4 = GL_UNSIGNED_SHORT_4_4_4_4;
    UNSIGNED_SHORT_5_5_5_1 = GL_UNSIGNED_SHORT_5_5_5_1;

    RGBA4 = GL_RGBA4;
    RGB5_A1 = GL_RGB5_A1;
    RGB565 = GL_RGB565;
    RGB8 = GL_RGB8;
    RGBA8 = GL_RGBA8;
    ALPHA8 = GL21_GL_ALPHA8; // TODO: not used, not core, remove

    READ_ONLY = GL_READ_ONLY;
    WRITE_ONLY = GL_WRITE_ONLY;
    READ_WRITE = GL_READ_WRITE;

    TESS_WINDING_NONZERO = PGLU.GLU_TESS_WINDING_NONZERO;
    TESS_WINDING_ODD = PGLU.GLU_TESS_WINDING_ODD;
    TESS_EDGE_FLAG = PGLU.GLU_TESS_EDGE_FLAG; // TODO: not used, not core, remove

    GENERATE_MIPMAP_HINT = GL21_GL_GENERATE_MIPMAP_HINT; // TODO: not used, not core, remove
    FASTEST = GL_FASTEST;
    NICEST = GL_NICEST;
    DONT_CARE = GL_DONT_CARE;

    VENDOR = GL_VENDOR;
    RENDERER = GL_RENDERER;
    VERSION = GL_VERSION;
    EXTENSIONS = GL_EXTENSIONS;
    SHADING_LANGUAGE_VERSION = GL_SHADING_LANGUAGE_VERSION;

    MAX_SAMPLES = GL_MAX_SAMPLES;
    SAMPLES = GL_SAMPLES;

    ALIASED_LINE_WIDTH_RANGE = GL_ALIASED_LINE_WIDTH_RANGE;
    ALIASED_POINT_SIZE_RANGE = GL21_GL_ALIASED_POINT_SIZE_RANGE; // TODO: not used, not core, remove

    DEPTH_BITS = GL21_GL_DEPTH_BITS; // TODO: not used, not core, remove
    STENCIL_BITS = GL21_GL_STENCIL_BITS; // TODO: not used, not core, remove

    CCW = GL_CCW;
    CW = GL_CW;

    VIEWPORT = GL_VIEWPORT;

    ARRAY_BUFFER = GL_ARRAY_BUFFER;
    ELEMENT_ARRAY_BUFFER = GL_ELEMENT_ARRAY_BUFFER;
    PIXEL_PACK_BUFFER = GL_PIXEL_PACK_BUFFER;

    MAX_VERTEX_ATTRIBS = GL_MAX_VERTEX_ATTRIBS;

    STATIC_DRAW = GL_STATIC_DRAW;
    DYNAMIC_DRAW = GL_DYNAMIC_DRAW;
    STREAM_DRAW = GL_STREAM_DRAW;
    STREAM_READ = GL_STREAM_READ;

    BUFFER_SIZE = GL_BUFFER_SIZE;
    BUFFER_USAGE = GL_BUFFER_USAGE;

    POINTS = GL_POINTS;
    LINE_STRIP = GL_LINE_STRIP;
    LINE_LOOP = GL_LINE_LOOP;
    LINES = GL_LINES;
    TRIANGLE_FAN = GL_TRIANGLE_FAN;
    TRIANGLE_STRIP = GL_TRIANGLE_STRIP;
    TRIANGLES = GL_TRIANGLES;

    CULL_FACE = GL_CULL_FACE;
    FRONT = GL_FRONT;
    BACK = GL_BACK;
    FRONT_AND_BACK = GL_FRONT_AND_BACK;

    POLYGON_OFFSET_FILL = GL_POLYGON_OFFSET_FILL;

    UNPACK_ALIGNMENT = GL_UNPACK_ALIGNMENT;
    PACK_ALIGNMENT = GL_PACK_ALIGNMENT;

    TEXTURE_2D = GL_TEXTURE_2D;
    TEXTURE_RECTANGLE = GL32C_GL_TEXTURE_RECTANGLE; // TODO: rectangular textures are not used anywhere, remove

    TEXTURE_BINDING_2D = GL_TEXTURE_BINDING_2D;
    TEXTURE_BINDING_RECTANGLE = GL32C_GL_TEXTURE_BINDING_RECTANGLE; // TODO: rectangular textures are not used anywhere, remove

    MAX_TEXTURE_SIZE = GL_MAX_TEXTURE_SIZE;
    TEXTURE_MAX_ANISOTROPY = GL_TEXTURE_MAX_ANISOTROPY;
    MAX_TEXTURE_MAX_ANISOTROPY = GL_MAX_TEXTURE_MAX_ANISOTROPY;

    MAX_VERTEX_TEXTURE_IMAGE_UNITS = GL_MAX_VERTEX_TEXTURE_IMAGE_UNITS;
    MAX_TEXTURE_IMAGE_UNITS = GL_MAX_TEXTURE_IMAGE_UNITS;
    MAX_COMBINED_TEXTURE_IMAGE_UNITS = GL_MAX_COMBINED_TEXTURE_IMAGE_UNITS;

    NUM_COMPRESSED_TEXTURE_FORMATS = GL_NUM_COMPRESSED_TEXTURE_FORMATS;
    COMPRESSED_TEXTURE_FORMATS = GL_COMPRESSED_TEXTURE_FORMATS;

    NEAREST = GL_NEAREST;
    LINEAR = GL_LINEAR;
    LINEAR_MIPMAP_NEAREST = GL_LINEAR_MIPMAP_NEAREST;
    LINEAR_MIPMAP_LINEAR = GL_LINEAR_MIPMAP_LINEAR;

    CLAMP_TO_EDGE = GL_CLAMP_TO_EDGE;
    REPEAT = GL_REPEAT;

    TEXTURE0 = GL_TEXTURE0;
    TEXTURE1 = GL_TEXTURE1;
    TEXTURE2 = GL_TEXTURE2;
    TEXTURE3 = GL_TEXTURE3;
    TEXTURE_MIN_FILTER = GL_TEXTURE_MIN_FILTER;
    TEXTURE_MAG_FILTER = GL_TEXTURE_MAG_FILTER;
    TEXTURE_WRAP_S = GL_TEXTURE_WRAP_S;
    TEXTURE_WRAP_T = GL_TEXTURE_WRAP_T;
    TEXTURE_WRAP_R = GL_TEXTURE_WRAP_R;

    TEXTURE_CUBE_MAP = GL_TEXTURE_CUBE_MAP;
    TEXTURE_CUBE_MAP_POSITIVE_X = GL_TEXTURE_CUBE_MAP_POSITIVE_X;
    TEXTURE_CUBE_MAP_POSITIVE_Y = GL_TEXTURE_CUBE_MAP_POSITIVE_Y;
    TEXTURE_CUBE_MAP_POSITIVE_Z = GL_TEXTURE_CUBE_MAP_POSITIVE_Z;
    TEXTURE_CUBE_MAP_NEGATIVE_X = GL_TEXTURE_CUBE_MAP_NEGATIVE_X;
    TEXTURE_CUBE_MAP_NEGATIVE_Y = GL_TEXTURE_CUBE_MAP_NEGATIVE_Y;
    TEXTURE_CUBE_MAP_NEGATIVE_Z = GL_TEXTURE_CUBE_MAP_NEGATIVE_Z;

    VERTEX_SHADER = GL_VERTEX_SHADER;
    FRAGMENT_SHADER = GL_FRAGMENT_SHADER;
    INFO_LOG_LENGTH = GL_INFO_LOG_LENGTH;
    SHADER_SOURCE_LENGTH = GL_SHADER_SOURCE_LENGTH;
    COMPILE_STATUS = GL_COMPILE_STATUS;
    LINK_STATUS = GL_LINK_STATUS;
    VALIDATE_STATUS = GL_VALIDATE_STATUS;
    SHADER_TYPE = GL_SHADER_TYPE;
    DELETE_STATUS = GL_DELETE_STATUS;

    FLOAT_VEC2 = GL_FLOAT_VEC2;
    FLOAT_VEC3 = GL_FLOAT_VEC3;
    FLOAT_VEC4 = GL_FLOAT_VEC4;
    FLOAT_MAT2 = GL_FLOAT_MAT2;
    FLOAT_MAT3 = GL_FLOAT_MAT3;
    FLOAT_MAT4 = GL_FLOAT_MAT4;
    INT_VEC2 = GL_INT_VEC2;
    INT_VEC3 = GL_INT_VEC3;
    INT_VEC4 = GL_INT_VEC4;
    BOOL_VEC2 = GL_BOOL_VEC2;
    BOOL_VEC3 = GL_BOOL_VEC3;
    BOOL_VEC4 = GL_BOOL_VEC4;
    SAMPLER_2D = GL_SAMPLER_2D;
    SAMPLER_CUBE = GL_SAMPLER_CUBE;

    LOW_FLOAT = GL_LOW_FLOAT;
    MEDIUM_FLOAT = GL_MEDIUM_FLOAT;
    HIGH_FLOAT = GL_HIGH_FLOAT;
    LOW_INT = GL_LOW_INT;
    MEDIUM_INT = GL_MEDIUM_INT;
    HIGH_INT = GL_HIGH_INT;

    CURRENT_VERTEX_ATTRIB = GL_CURRENT_VERTEX_ATTRIB;

    VERTEX_ATTRIB_ARRAY_BUFFER_BINDING = GL_VERTEX_ATTRIB_ARRAY_BUFFER_BINDING;
    VERTEX_ATTRIB_ARRAY_ENABLED = GL_VERTEX_ATTRIB_ARRAY_ENABLED;
    VERTEX_ATTRIB_ARRAY_SIZE = GL_VERTEX_ATTRIB_ARRAY_SIZE;
    VERTEX_ATTRIB_ARRAY_STRIDE = GL_VERTEX_ATTRIB_ARRAY_STRIDE;
    VERTEX_ATTRIB_ARRAY_TYPE = GL_VERTEX_ATTRIB_ARRAY_TYPE;
    VERTEX_ATTRIB_ARRAY_NORMALIZED = GL_VERTEX_ATTRIB_ARRAY_NORMALIZED;
    VERTEX_ATTRIB_ARRAY_POINTER = GL_VERTEX_ATTRIB_ARRAY_POINTER;

    BLEND = GL_BLEND;
    ONE = GL_ONE;
    ZERO = GL_ZERO;
    SRC_ALPHA = GL_SRC_ALPHA;
    DST_ALPHA = GL_DST_ALPHA;
    ONE_MINUS_SRC_ALPHA = GL_ONE_MINUS_SRC_ALPHA;
    ONE_MINUS_DST_COLOR = GL_ONE_MINUS_DST_COLOR;
    ONE_MINUS_SRC_COLOR = GL_ONE_MINUS_SRC_COLOR;
    DST_COLOR = GL_DST_COLOR;
    SRC_COLOR = GL_SRC_COLOR;

    SAMPLE_ALPHA_TO_COVERAGE = GL_SAMPLE_ALPHA_TO_COVERAGE;
    SAMPLE_COVERAGE = GL_SAMPLE_COVERAGE;

    KEEP = GL_KEEP;
    REPLACE = GL_REPLACE;
    INCR = GL_INCR;
    DECR = GL_DECR;
    INVERT = GL_INVERT;
    INCR_WRAP = GL_INCR_WRAP;
    DECR_WRAP = GL_DECR_WRAP;
    NEVER = GL_NEVER;
    ALWAYS = GL_ALWAYS;

    EQUAL = GL_EQUAL;
    LESS = GL_LESS;
    LEQUAL = GL_LEQUAL;
    GREATER = GL_GREATER;
    GEQUAL = GL_GEQUAL;
    NOTEQUAL = GL_NOTEQUAL;

    FUNC_ADD = GL_FUNC_ADD;
    FUNC_MIN = GL_MIN;
    FUNC_MAX = GL_MAX;
    FUNC_REVERSE_SUBTRACT = GL_FUNC_REVERSE_SUBTRACT;
    FUNC_SUBTRACT = GL_FUNC_SUBTRACT;

    DITHER = GL_DITHER;

    CONSTANT_COLOR = GL_CONSTANT_COLOR;
    CONSTANT_ALPHA = GL_CONSTANT_ALPHA;
    ONE_MINUS_CONSTANT_COLOR = GL_ONE_MINUS_CONSTANT_COLOR;
    ONE_MINUS_CONSTANT_ALPHA = GL_ONE_MINUS_CONSTANT_ALPHA;
    SRC_ALPHA_SATURATE = GL_SRC_ALPHA_SATURATE;

    SCISSOR_TEST = GL_SCISSOR_TEST;
    STENCIL_TEST = GL_STENCIL_TEST;
    DEPTH_TEST = GL_DEPTH_TEST;
    DEPTH_WRITEMASK = GL_DEPTH_WRITEMASK;

    COLOR_BUFFER_BIT = GL_COLOR_BUFFER_BIT;
    DEPTH_BUFFER_BIT = GL_DEPTH_BUFFER_BIT;
    STENCIL_BUFFER_BIT = GL_STENCIL_BUFFER_BIT;

    FRAMEBUFFER = GL_FRAMEBUFFER;
    COLOR_ATTACHMENT0 = GL_COLOR_ATTACHMENT0;
    COLOR_ATTACHMENT1 = GL_COLOR_ATTACHMENT1;
    COLOR_ATTACHMENT2 = GL_COLOR_ATTACHMENT2;
    COLOR_ATTACHMENT3 = GL_COLOR_ATTACHMENT3;
    RENDERBUFFER = GL_RENDERBUFFER;
    DEPTH_ATTACHMENT = GL_DEPTH_ATTACHMENT;
    STENCIL_ATTACHMENT = GL_STENCIL_ATTACHMENT;
    READ_FRAMEBUFFER = GL_READ_FRAMEBUFFER;
    DRAW_FRAMEBUFFER = GL_DRAW_FRAMEBUFFER;

    DEPTH24_STENCIL8 = GL_DEPTH24_STENCIL8;

    DEPTH_COMPONENT = GL_DEPTH_COMPONENT;
    DEPTH_COMPONENT16 = GL_DEPTH_COMPONENT16;
    DEPTH_COMPONENT24 = GL_DEPTH_COMPONENT24;
    DEPTH_COMPONENT32 = GL_DEPTH_COMPONENT32;

    STENCIL_INDEX = GL_STENCIL_INDEX;
    STENCIL_INDEX1 = GL_STENCIL_INDEX1;
    STENCIL_INDEX4 = GL_STENCIL_INDEX4;
    STENCIL_INDEX8 = GL_STENCIL_INDEX8;

    DEPTH_STENCIL = GL_DEPTH_STENCIL;

    FRAMEBUFFER_COMPLETE = GL_FRAMEBUFFER_COMPLETE;
    FRAMEBUFFER_UNDEFINED = GL_FRAMEBUFFER_UNDEFINED;
    FRAMEBUFFER_INCOMPLETE_ATTACHMENT = GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT;
    FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT = GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT;
    FRAMEBUFFER_INCOMPLETE_DIMENSIONS = EXTFramebufferObject_GL_FRAMEBUFFER_INCOMPLETE_DIMENSIONS_EXT; // TODO: not part of standard OpenGL, remove
    FRAMEBUFFER_INCOMPLETE_FORMATS = EXTFramebufferObject_GL_FRAMEBUFFER_INCOMPLETE_FORMATS_EXT; // TODO: not part of standard OpenGL, remove
    FRAMEBUFFER_INCOMPLETE_DRAW_BUFFER = GL_FRAMEBUFFER_INCOMPLETE_DRAW_BUFFER;
    FRAMEBUFFER_INCOMPLETE_READ_BUFFER = GL_FRAMEBUFFER_INCOMPLETE_READ_BUFFER;
    FRAMEBUFFER_UNSUPPORTED = GL_FRAMEBUFFER_UNSUPPORTED;
    FRAMEBUFFER_INCOMPLETE_MULTISAMPLE = GL_FRAMEBUFFER_INCOMPLETE_MULTISAMPLE;
    FRAMEBUFFER_INCOMPLETE_LAYER_TARGETS = GL32C_GL_FRAMEBUFFER_INCOMPLETE_LAYER_TARGETS;

    FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE = GL_FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE;
    FRAMEBUFFER_ATTACHMENT_OBJECT_NAME = GL_FRAMEBUFFER_ATTACHMENT_OBJECT_NAME;
    FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL = GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL;
    FRAMEBUFFER_ATTACHMENT_TEXTURE_CUBE_MAP_FACE = GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_CUBE_MAP_FACE;

    RENDERBUFFER_WIDTH = GL_RENDERBUFFER_WIDTH;
    RENDERBUFFER_HEIGHT = GL_RENDERBUFFER_HEIGHT;
    RENDERBUFFER_RED_SIZE = GL_RENDERBUFFER_RED_SIZE;
    RENDERBUFFER_GREEN_SIZE = GL_RENDERBUFFER_GREEN_SIZE;
    RENDERBUFFER_BLUE_SIZE = GL_RENDERBUFFER_BLUE_SIZE;
    RENDERBUFFER_ALPHA_SIZE = GL_RENDERBUFFER_ALPHA_SIZE;
    RENDERBUFFER_DEPTH_SIZE = GL_RENDERBUFFER_DEPTH_SIZE;
    RENDERBUFFER_STENCIL_SIZE = GL_RENDERBUFFER_STENCIL_SIZE;
    RENDERBUFFER_INTERNAL_FORMAT = GL_RENDERBUFFER_INTERNAL_FORMAT;

    MULTISAMPLE = GL_MULTISAMPLE;
    LINE_SMOOTH = GL_LINE_SMOOTH;
    POLYGON_SMOOTH = GL_POLYGON_SMOOTH;

    SYNC_GPU_COMMANDS_COMPLETE = GL_SYNC_GPU_COMMANDS_COMPLETE;
    ALREADY_SIGNALED = GL_ALREADY_SIGNALED;
    CONDITION_SATISFIED = GL_CONDITION_SATISFIED;
  }

  ///////////////////////////////////////////////////////////

  // Special Functions

  @Override
  public void flush() {
    // glFlush();
    throw new NotImplementedException("flush() unimplemented for BGFX");
  }

  @Override
  public void finish() {
    // glFinish();
    throw new NotImplementedException("finish() unimplemented for BGFX");
  }

  @Override
  public void hint(int target, int hint) {
    // glHint(target, hint);
    throw new NotImplementedException("hint() unimplemented for BGFX");
  }

  ///////////////////////////////////////////////////////////

  // State and State Requests

  @Override
  public void enable(int value) {
    // if (-1 < value) {
    //   glEnable(value);
    // }
    throw new NotImplementedException("enable() unimplemented for BGFX");
  }

  @Override
  public void disable(int value) {
    // if (-1 < value) {
    //   glDisable(value);
    // }
    throw new NotImplementedException("disable() unimplemented for BGFX");
  }

  @Override
  public void getBooleanv(int value, IntBuffer data) {
    // // TODO: needs change to ByteBuffer, should have a variant which returns
    // //       a single boolean via 'glGetBoolean(int pname)'
    // if (-1 < value) {
    //   if (byteBuffer.capacity() < data.capacity()) {
    //     byteBuffer = allocateDirectByteBuffer(data.capacity());
    //   }
    //   glGetBooleanv(value, byteBuffer);
    //   for (int i = 0; i < data.capacity(); i++) {
    //     data.put(i, byteBuffer.get(i));
    //   }
    // } else {
    //   fillIntBuffer(data, 0, data.capacity() - 1, 0);
    // }

    throw new NotImplementedException("getBooleanv() unimplemented for BGFX");
  }

  @Override
  public void getIntegerv(int value, IntBuffer data) {
    // // TODO: should have variant which returns a single int via
    // //       'glGetInteger(int pname)'
    // if (-1 < value) {
    //   glGetIntegerv(value, data);
    // } else {
    //   fillIntBuffer(data, 0, data.capacity() - 1, 0);
    // }

    throw new NotImplementedException("getIntegerv() unimplemented for BGFX");
  }

  @Override
  public void getFloatv(int value, FloatBuffer data) {
    // // TODO: should have variant which returns a single float via
    // //       'glGetFloat(int pname)'
    // if (-1 < value) {
    //   glGetFloatv(value, data);
    // } else {
    //   fillFloatBuffer(data, 0, data.capacity() - 1, 0);
    // }

    throw new NotImplementedException("getFloatv() unimplemented for BGFX");
  }

  @Override
  public boolean isEnabled(int value) {
    // return glIsEnabled(value);
    throw new NotImplementedException("isEnabled() unimplemented for BGFX");
  }

  @Override
  public String getString(int __name) {
    // return glGetString(name);

    int id = __name;
    String name = DummyGLConstantsNames.getName(id);
    String hex = Integer.toHexString(id).toUpperCase();

    logWarning("getString(" + name + ") was called" +
      " (" + name + " = " + id + " = " + "0x" + hex + ")");

    throw new NotImplementedException("getString() unimplemented for BGFX");
  }

  // public static Logger getLogger() {
  //   return Logger.getLogger("PLWJGL");
  // }

  public static void logWarning(String message) {
    // getLogger().warning(message);
    PGraphics.showWarning("(PLWJGL) [Warn] " + message);
  }

  public static void logInfo(String message) {
    // getLogger().info(message);
    PGraphics.showWarning("(PLWJGL) [Info] " + message);
  }

  protected static Map<String, Boolean> warningMap = new HashMap<String, Boolean>();

  public static void logWarningOnce(String onceKey, String message) {
    if (!warningMap.containsKey(onceKey)) {
      warningMap.put(onceKey, true);
      logWarning(message);
    }
  }

  ///////////////////////////////////////////////////////////

  // Error Handling

  @Override
  public int getError() {
    // return glGetError();

    // throw new NotImplementedException("getError() unimplemented for BGFX");

    // logWarning("getError() currently does nothing in BGFX");
    logWarningOnce("getError()", "getError() currently does nothing in BGFX");

    return 0;
  }

  @Override
  public String errorString(int err) {
    switch (err) {
    case 0: return "no error";
    case 1280: return "invalid enumerant";
    case 1281: return "invalid value";
    case 1282: return "invalid operation";
    case 1283: return "stack overflow";
    case 1284: return "stack underflow";
    case 1285: return "out of memory";
    case 1286: return "invalid framebuffer operation";
    case 32817: return "table too large";
    default: return PGLU.gluErrorString(err);
    }
  }

  //////////////////////////////////////////////////////////////////////////////

  // Buffer Objects

  @Override
  public void genBuffers(int n, IntBuffer buffers) {
    // buffers.limit(n); // TODO: caller should set the position and the limit
    // glGenBuffers(buffers);
    // buffers.limit(buffers.capacity());

    throw new NotImplementedException("genBuffers() unimplemented for BGFX");
  }

  @Override
  public void deleteBuffers(int n, IntBuffer buffers) {
    // buffers.limit(n); // TODO: caller should set the position and the limit
    // glDeleteBuffers(buffers);
    // buffers.limit(buffers.capacity());

    throw new NotImplementedException("deleteBuffers() unimplemented for BGFX");
  }

  @Override
  public void bindBuffer(int target, int buffer) {
    // glBindBuffer(target, buffer);
    throw new NotImplementedException("bindBuffer() unimplemented for BGFX");
  }

  @Override
  public void bufferData(int target, int size, Buffer data, int usage) {
    // // TODO: caller should set the position and the limit
    // // TODO: This needs overloads for each buffer type
    // if (data == null) {
    //   glBufferData(target, size, usage);
    // } else {
    //   if (data instanceof FloatBuffer) {
    //     data.limit(data.position() + size / Float.BYTES);
    //     glBufferData(target, (FloatBuffer) data, usage);
    //   } else if (data instanceof IntBuffer) {
    //     data.limit(data.position() + size / Integer.BYTES);
    //     glBufferData(target, (IntBuffer) data, usage);
    //   } else if (data instanceof ByteBuffer) {
    //     data.limit(data.position() + size);
    //     glBufferData(target, (ByteBuffer) data, usage);
    //   } else if (data instanceof ShortBuffer) {
    //     data.limit(data.position() + size / Short.BYTES);
    //     glBufferData(target, (ShortBuffer) data, usage);
    //   }
    //   data.limit(data.capacity());
    // }

    throw new NotImplementedException("bufferData() unimplemented for BGFX");
  }

  @Override
  public void bufferSubData(int target, int offset, int size, Buffer data) {
    // // TODO: caller should set the position and the limit
    // // TODO: This needs overloads for each buffer type
    // if (data instanceof FloatBuffer) {
    //   data.limit(data.position() + size / Float.BYTES);
    //   glBufferSubData(target, offset, (FloatBuffer) data);
    // } else if (data instanceof IntBuffer) {
    //   data.limit(data.position() + size / Integer.BYTES);
    //   glBufferSubData(target, offset, (IntBuffer) data);
    // } else if (data instanceof ByteBuffer) {
    //   data.limit(data.position() + size);
    //   glBufferSubData(target, offset, (ByteBuffer) data);
    // } else if (data instanceof ShortBuffer) {
    //   data.limit(data.position() + size / Short.BYTES);
    //   glBufferSubData(target, offset, (ShortBuffer) data);
    // }
    // data.limit(data.capacity());

    throw new NotImplementedException("bufferSubData() unimplemented for BGFX");
  }

  @Override
  public void isBuffer(int buffer) {
    // glIsBuffer(buffer);
    throw new NotImplementedException("isBuffer() unimplemented for BGFX");
  }

  @Override
  public void getBufferParameteriv(int target, int value, IntBuffer data) {
    // if (-1 < value) {
    //   glGetBufferParameteriv(target, value, data);
    // } else {
    //   data.put(0, 0);
    // }

    throw new NotImplementedException("getBufferParameteriv() unimplemented for BGFX");
  }

  @Override
  public ByteBuffer mapBuffer(int target, int access) {
    // return glMapBuffer(target, access);
    throw new NotImplementedException("mapBuffer() unimplemented for BGFX");
  }

  @Override
  public ByteBuffer mapBufferRange(int target, int offset, int length, int access) {
    // return ARBMapBufferRange.glMapBufferRange(target, offset, length, access);
    throw new NotImplementedException("mapBufferRange() unimplemented for BGFX");
  }

  @Override
  public void unmapBuffer(int target) {
    // glUnmapBuffer(target);
    throw new NotImplementedException("unmapBuffer() unimplemented for BGFX");
  }


  //////////////////////////////////////////////////////////////////////////////

  // Sync

  @Override
  public long fenceSync(int condition, int flags) {
    // return glFenceSync(condition, flags);
    throw new NotImplementedException("fenceSync() unimplemented for BGFX");
  }


  @Override
  public void deleteSync(long sync) {
    // glDeleteSync(sync);
    throw new NotImplementedException("deleteSync() unimplemented for BGFX");
  }


  @Override
  public int clientWaitSync(long sync, int flags, long timeout) {
    // return glClientWaitSync(sync, flags, timeout);
    throw new NotImplementedException("clientWaitSync() unimplemented for BGFX");
  }

  //////////////////////////////////////////////////////////////////////////////

  // Viewport and Clipping

  @Override
  public void depthRangef(float n, float f) {
    // glDepthRange(n, f);
    throw new NotImplementedException("depthRangef() unimplemented for BGFX");
  }

  @Override
  public void viewport(int x, int y, int w, int h) {
    // float f = getPixelScale();
    // viewportImpl((int)(f*x), (int)(f*y), (int)(f*w), (int)(f*h));

    throw new NotImplementedException("viewport() unimplemented for BGFX");
  }

  @Override
  protected void viewportImpl(int x, int y, int w, int h) {
    // glViewport(x, y, w, h);

    throw new NotImplementedException("viewportImpl() unimplemented for BGFX");
  }

  //////////////////////////////////////////////////////////////////////////////

  // Reading Pixels

  @Override
  protected void readPixelsImpl(int x, int y, int width, int height, int format, int type, Buffer buffer) {
    // // TODO: needs overloads for different buffers
    // glReadPixels(x, y, width, height, format, type, (IntBuffer)buffer);

    throw new NotImplementedException("readPixelsImpl() unimplemented for BGFX");
  }

  @Override
  protected void readPixelsImpl(int x, int y, int width, int height, int format,
                                int type, long offset) {
    // // TODO: used by async pixel reader, test if it works
    // glReadPixels(x, y, width, height, format, type, offset);

    throw new NotImplementedException("readPixelsImpl() unimplemented for BGFX");
  }

  //////////////////////////////////////////////////////////////////////////////

  // Vertices

  @Override
  public void vertexAttrib1f(int index, float value) {
    // glVertexAttrib1f(index, value);
    throw new NotImplementedException("vertexAttrib1f() unimplemented for BGFX");
  }

  @Override
  public void vertexAttrib2f(int index, float value0, float value1) {
    // glVertexAttrib2f(index, value0, value1);
    throw new NotImplementedException("vertexAttrib2f() unimplemented for BGFX");
  }

  @Override
  public void vertexAttrib3f(int index, float value0, float value1, float value2) {
    // glVertexAttrib3f(index, value0, value1, value2);
    throw new NotImplementedException("vertexAttrib3f() unimplemented for BGFX");
  }

  @Override
  public void vertexAttrib4f(int index, float value0, float value1, float value2, float value3) {
    // glVertexAttrib4f(index, value0, value1, value2, value3);
    throw new NotImplementedException("vertexAttrib4f() unimplemented for BGFX");
  }

  @Override
  public void vertexAttrib1fv(int index, FloatBuffer values) {
    // glVertexAttrib1fv(index, values);
    throw new NotImplementedException("vertexAttrib1fv() unimplemented for BGFX");
  }

  @Override
  public void vertexAttrib2fv(int index, FloatBuffer values) {
    // glVertexAttrib2fv(index, values);
    throw new NotImplementedException("vertexAttrib2fv() unimplemented for BGFX");
  }

  @Override
  public void vertexAttrib3fv(int index, FloatBuffer values) {
    // glVertexAttrib3fv(index, values);
    throw new NotImplementedException("vertexAttrib3fv() unimplemented for BGFX");
  }

  @Override
  public void vertexAttrib4fv(int index, FloatBuffer values) {
    // glVertexAttrib4fv(index, values);
    throw new NotImplementedException("vertexAttrib4fv() unimplemented for BGFX");
  }

  @Override
  public void vertexAttribPointer(int index, int size, int type, boolean normalized, int stride, int offset) {
    // glVertexAttribPointer(index, size, type, normalized, stride, offset);
    throw new NotImplementedException("vertexAttribPointer() unimplemented for BGFX");
  }

  @Override
  public void enableVertexAttribArray(int index) {
    // glEnableVertexAttribArray(index);
    throw new NotImplementedException("enableVertexAttribArray() unimplemented for BGFX");
  }

  @Override
  public void disableVertexAttribArray(int index) {
    // glDisableVertexAttribArray(index);
    throw new NotImplementedException("disableVertexAttribArray() unimplemented for BGFX");
  }

  @Override
  public void drawArraysImpl(int mode, int first, int count) {
    // glDrawArrays(mode, first, count);
    throw new NotImplementedException("drawArraysImpl() unimplemented for BGFX");
  }

  @Override
  public void drawElementsImpl(int mode, int count, int type, int offset) {
    // glDrawElements(mode, count, type, offset);
    throw new NotImplementedException("drawElementsImpl() unimplemented for BGFX");
  }

//  @Override
//  public void drawElements(int mode, int count, int type, Buffer indices) {
//    if (type == UNSIGNED_INT) {
//      glDrawElements(mode, (IntBuffer)indices);
//    } else if (type == UNSIGNED_BYTE) {
//      glDrawElements(mode, (ByteBuffer)indices);
//    } else if (type == UNSIGNED_SHORT) {
//      glDrawElements(mode, (ShortBuffer)indices);
//    }
//  }

  //////////////////////////////////////////////////////////////////////////////

  // Rasterization

  @Override
  public void lineWidth(float width) {
    // glLineWidth(width);
    throw new NotImplementedException("lineWidth() unimplemented for BGFX");
  }

  @Override
  public void frontFace(int dir) {
    // glFrontFace(dir);
    throw new NotImplementedException("frontFace() unimplemented for BGFX");
  }

  @Override
  public void cullFace(int mode) {
    // glCullFace(mode);
    throw new NotImplementedException("cullFace() unimplemented for BGFX");
  }

  @Override
  public void polygonOffset(float factor, float units) {
    // glPolygonOffset(factor, units);
    throw new NotImplementedException("polygonOffset() unimplemented for BGFX");
  }

  //////////////////////////////////////////////////////////////////////////////

  // Pixel Rectangles

  @Override
  public void pixelStorei(int pname, int param) {
    // glPixelStorei(pname, param);
    throw new NotImplementedException("pixelStorei() unimplemented for BGFX");
  }

  ///////////////////////////////////////////////////////////

  // Texturing

  @Override
  public void texImage2D(int target, int level, int internalFormat, int width, int height, int border, int format, int type, Buffer data) {
    // // TODO: needs change to IntBuffer
    // glTexImage2D(target, level, internalFormat, width, height, border, format, type, (IntBuffer)data);

    throw new NotImplementedException("texImage2D() unimplemented for BGFX");
  }

  @Override
  public void copyTexImage2D(int target, int level, int internalFormat, int x, int y, int width, int height, int border) {
    // glCopyTexImage2D(target, level, internalFormat, x, y, width, height, border);
    throw new NotImplementedException("copyTexImage2D() unimplemented for BGFX");
  }

  @Override
  public void texSubImage2D(int target, int level, int xOffset, int yOffset, int width, int height, int format, int type, Buffer data) {
    // // TODO: needs change to IntBuffer
    // glTexSubImage2D(target, level, xOffset, yOffset, width, height, format, type, (IntBuffer)data);

    throw new NotImplementedException("texSubImage2D() unimplemented for BGFX");
  }

  @Override
  public void copyTexSubImage2D(int target, int level, int xOffset, int yOffset, int x, int y, int width, int height) {
    // glCopyTexSubImage2D(target, level, x, y, xOffset, yOffset, width, height);
    throw new NotImplementedException("copyTexSubImage2D() unimplemented for BGFX");
  }

  @Override
  public void compressedTexImage2D(int target, int level, int internalFormat, int width, int height, int border, int imageSize, Buffer data) {
    // // TODO: needs change to ByteBuffer
    // glCompressedTexImage2D(target, level, internalFormat, width, height, border, (ByteBuffer)data);

    throw new NotImplementedException("compressedTexImage2D() unimplemented for BGFX");
  }

  @Override
  public void compressedTexSubImage2D(int target, int level, int xOffset, int yOffset, int width, int height, int format, int imageSize, Buffer data) {
    // glCompressedTexSubImage2D(target, level, xOffset, yOffset, width, height, format, (ByteBuffer)data);
    throw new NotImplementedException("compressedTexSubImage2D() unimplemented for BGFX");
  }

  @Override
  public void texParameteri(int target, int pname, int param) {
    // glTexParameteri(target, pname, param);
    throw new NotImplementedException("texParameteri() unimplemented for BGFX");
  }

  @Override
  public void texParameterf(int target, int pname, float param) {
    // glTexParameterf(target, pname, param);
    throw new NotImplementedException("texParameterf() unimplemented for BGFX");
  }

  @Override
  public void texParameteriv(int target, int pname, IntBuffer params) {
    // glTexParameteriv(target, pname, params);
    throw new NotImplementedException("texParameteriv() unimplemented for BGFX");
  }

  @Override
  public void texParameterfv(int target, int pname, FloatBuffer params) {
    // glTexParameterfv(target, pname, params);
    throw new NotImplementedException("texParameterfv() unimplemented for BGFX");
  }

  @Override
  public void generateMipmap(int target) {
    // glGenerateMipmap(target);
    throw new NotImplementedException("generateMipmap() unimplemented for BGFX");
  }

  @Override
  public void genTextures(int n, IntBuffer textures) {
    // glGenTextures(textures);
    throw new NotImplementedException("genTextures() unimplemented for BGFX");
  }

  @Override
  public void deleteTextures(int n, IntBuffer textures) {
    // glDeleteTextures(textures);
    throw new NotImplementedException("deleteTextures() unimplemented for BGFX");
  }

  @Override
  public void getTexParameteriv(int target, int pname, IntBuffer params) {
    // glGetTexParameteriv(target, pname, params);
    throw new NotImplementedException("getTexParameteriv() unimplemented for BGFX");
  }

  @Override
  public void getTexParameterfv(int target, int pname, FloatBuffer params) {
    // glGetTexParameterfv(target, pname, params);
    throw new NotImplementedException("getTexParameterfv() unimplemented for BGFX");
  }

  @Override
  public boolean isTexture(int texture) {
    // return glIsTexture(texture);
    throw new NotImplementedException("isTexture() unimplemented for BGFX");
  }

  @Override
  protected void activeTextureImpl(int texture) {
    // glActiveTexture(texture);
    throw new NotImplementedException("activeTextureImpl() unimplemented for BGFX");
  }

  @Override
  protected void bindTextureImpl(int target, int texture) {
    // glBindTexture(target, texture);
    throw new NotImplementedException("bindTextureImpl() unimplemented for BGFX");
  }

  ///////////////////////////////////////////////////////////

  // Shaders and Programs

  @Override
  public int createShader(int type) {
    // return glCreateShader(type);
    throw new NotImplementedException("createShader() unimplemented for BGFX");
  }

  @Override
  public void shaderSource(int shader, String source) {
    // glShaderSource(shader, source);
    throw new NotImplementedException("shaderSource() unimplemented for BGFX");
  }

  @Override
  public void compileShader(int shader) {
    // glCompileShader(shader);
    throw new NotImplementedException("compileShader() unimplemented for BGFX");
  }

  @Override
  public void releaseShaderCompiler() {
    // glReleaseShaderCompiler();
    throw new NotImplementedException("releaseShaderCompiler() unimplemented for BGFX");
  }

  @Override
  public void deleteShader(int shader) {
    // glDeleteShader(shader);
    throw new NotImplementedException("deleteShader() unimplemented for BGFX");
  }

  @Override
  public void shaderBinary(int count, IntBuffer shaders, int binaryFormat, Buffer binary, int length) {
    // glShaderBinary(shaders, binaryFormat, (ByteBuffer) binary);
    throw new NotImplementedException("shaderBinary() unimplemented for BGFX");
  }

  @Override
  public int createProgram() {
    // return glCreateProgram();
    throw new NotImplementedException("createProgram() unimplemented for BGFX");
  }

  @Override
  public void attachShader(int program, int shader) {
    // glAttachShader(program, shader);
    throw new NotImplementedException("attachShader() unimplemented for BGFX");
  }

  @Override
  public void detachShader(int program, int shader) {
    // glDetachShader(program, shader);
    throw new NotImplementedException("detachShader() unimplemented for BGFX");
  }

  @Override
  public void linkProgram(int program) {
    // glLinkProgram(program);
    throw new NotImplementedException("linkProgram() unimplemented for BGFX");
  }

  @Override
  public void useProgram(int program) {
    // glUseProgram(program);
    throw new NotImplementedException("useProgram() unimplemented for BGFX");
  }

  @Override
  public void deleteProgram(int program) {
    // glDeleteProgram(program);
    throw new NotImplementedException("deleteProgram() unimplemented for BGFX");
  }

  @Override
  public String getActiveAttrib(int program, int index, IntBuffer size, IntBuffer type) {
    // return glGetActiveAttrib(program, index, size, type);
    throw new NotImplementedException("getActiveAttrib() unimplemented for BGFX");
  }

  @Override
  public int getAttribLocation(int program, String name) {
    // return glGetAttribLocation(program, name);
    throw new NotImplementedException("getAttribLocation() unimplemented for BGFX");
  }

  @Override
  public void bindAttribLocation(int program, int index, String name) {
    // glBindAttribLocation(program, index, name);
    throw new NotImplementedException("bindAttribLocation() unimplemented for BGFX");
  }

  @Override
  public int getUniformLocation(int program, String name) {
    // return glGetUniformLocation(program, name);
    throw new NotImplementedException("getUniformLocation() unimplemented for BGFX");
  }

  @Override
  public String getActiveUniform(int program, int index, IntBuffer size, IntBuffer type) {
// //    IntBuffer typeTmp = BufferUtils.createIntBuffer(2);
// //    String name = glGetActiveUniform(program, index, 256, typeTmp);
// //    type.put(typeTmp.get(0));
// //    return name;
//     return glGetActiveUniform(program, index, size, type);

    throw new NotImplementedException("getActiveUniform() unimplemented for BGFX");
  }

  @Override
  public void uniform1i(int location, int value) {
    // glUniform1i(location, value);
    throw new NotImplementedException("uniform1i() unimplemented for BGFX");
  }

  @Override
  public void uniform2i(int location, int value0, int value1) {
    // glUniform2i(location, value0, value1);
    throw new NotImplementedException("uniform2i() unimplemented for BGFX");
  }

  @Override
  public void uniform3i(int location, int value0, int value1, int value2) {
    // glUniform3i(location, value0, value1, value2);
    throw new NotImplementedException("uniform3i() unimplemented for BGFX");
  }

  @Override
  public void uniform4i(int location, int value0, int value1, int value2, int value3) {
    // glUniform4i(location, value0, value1, value2, value3);
    throw new NotImplementedException("uniform4i() unimplemented for BGFX");
  }

  @Override
  public void uniform1f(int location, float value) {
    // glUniform1f(location, value);
    throw new NotImplementedException("uniform1f() unimplemented for BGFX");
  }

  @Override
  public void uniform2f(int location, float value0, float value1) {
    // glUniform2f(location, value0, value1);
    throw new NotImplementedException("uniform2f() unimplemented for BGFX");
  }

  @Override
  public void uniform3f(int location, float value0, float value1, float value2) {
    // glUniform3f(location, value0, value1, value2);
    throw new NotImplementedException("uniform3f() unimplemented for BGFX");
  }

  @Override
  public void uniform4f(int location, float value0, float value1, float value2, float value3) {
    // glUniform4f(location, value0, value1, value2, value3);
    throw new NotImplementedException("uniform4f() unimplemented for BGFX");
  }

  @Override
  public void uniform1iv(int location, int count, IntBuffer v) {
    // v.limit(count); // TODO: caller should set the position and the limit
    // glUniform1iv(location, v);
    // v.limit(v.capacity());

    throw new NotImplementedException("uniform1iv() unimplemented for BGFX");
  }

  @Override
  public void uniform2iv(int location, int count, IntBuffer v) {
    // v.limit(2*count); // TODO: caller should set the position and the limit
    // glUniform2iv(location, v);
    // v.limit(v.capacity());

    throw new NotImplementedException("uniform2iv() unimplemented for BGFX");
  }

  @Override
  public void uniform3iv(int location, int count, IntBuffer v) {
    // v.limit(3*count); // TODO: caller should set the position and the limit
    // glUniform3iv(location, v);
    // v.limit(v.capacity());

    throw new NotImplementedException("uniform3iv() unimplemented for BGFX");
  }

  @Override
  public void uniform4iv(int location, int count, IntBuffer v) {
    // v.limit(4*count); // TODO: caller should set the position and the limit
    // glUniform4iv(location, v);
    // v.limit(v.capacity());

    throw new NotImplementedException("uniform4iv() unimplemented for BGFX");
  }

  @Override
  public void uniform1fv(int location, int count, FloatBuffer v) {
    // v.limit(count); // TODO: caller should set the position and the limit
    // glUniform1fv(location, v);
    // v.limit(v.capacity());

    throw new NotImplementedException("uniform1fv() unimplemented for BGFX");
  }

  @Override
  public void uniform2fv(int location, int count, FloatBuffer v) {
    // v.limit(2*count); // TODO: caller should set the position and the limit
    // glUniform2fv(location, v);
    // v.limit(v.capacity());

    throw new NotImplementedException("uniform2fv() unimplemented for BGFX");
  }

  @Override
  public void uniform3fv(int location, int count, FloatBuffer v) {
    // v.limit(3*count); // TODO: caller should set the position and the limit
    // glUniform3fv(location, v);
    // v.limit(v.capacity());

    throw new NotImplementedException("uniform3fv() unimplemented for BGFX");
  }

  @Override
  public void uniform4fv(int location, int count, FloatBuffer v) {
    // v.limit(4*count); // TODO: caller should set the position and the limit
    // glUniform4fv(location, v);
    // v.limit(v.capacity());

    throw new NotImplementedException("uniform4fv() unimplemented for BGFX");
  }

  @Override
  public void uniformMatrix2fv(int location, int count, boolean transpose, FloatBuffer mat) {
    // mat.limit(4*count); // TODO: caller should set the position and the limit
    // glUniformMatrix2fv(location, transpose, mat);
    // mat.limit(mat.capacity());

    throw new NotImplementedException("uniformMatrix2fv() unimplemented for BGFX");
  }

  @Override
  public void uniformMatrix3fv(int location, int count, boolean transpose, FloatBuffer mat) {
    // mat.limit(9*count); // TODO: caller should set the position and the limit
    // glUniformMatrix3fv(location, transpose, mat);
    // mat.limit(mat.capacity());

    throw new NotImplementedException("uniformMatrix3fv() unimplemented for BGFX");
  }

  @Override
  public void uniformMatrix4fv(int location, int count, boolean transpose, FloatBuffer mat) {
    // mat.limit(16*count); // TODO: caller should set the position and the limit
    // glUniformMatrix4fv(location, transpose, mat);
    // mat.limit(mat.capacity());

    throw new NotImplementedException("uniformMatrix4fv() unimplemented for BGFX");
  }

  @Override
  public void validateProgram(int program) {
    // glValidateProgram(program);
    throw new NotImplementedException("validateProgram() unimplemented for BGFX");
  }

  @Override
  public boolean isShader(int shader) {
    // return glIsShader(shader);
    throw new NotImplementedException("isShader() unimplemented for BGFX");
  }

  @Override
  public void getShaderiv(int shader, int pname, IntBuffer params) {
    // glGetShaderiv(shader, pname, params);
    throw new NotImplementedException("getShaderiv() unimplemented for BGFX");
  }

  @Override
  public void getAttachedShaders(int program, int maxCount, IntBuffer count, IntBuffer shaders) {
    // glGetAttachedShaders(program, count, shaders);
    throw new NotImplementedException("getAttachedShaders() unimplemented for BGFX");
  }

  @Override
  public String getShaderInfoLog(int shader) {
    // int len = glGetShaderi(shader, GL_INFO_LOG_LENGTH);
    // return glGetShaderInfoLog(shader, len);

    throw new NotImplementedException("getShaderInfoLog() unimplemented for BGFX");
  }

  @Override
  public String getShaderSource(int shader) {
    // int len = glGetShaderi(shader, GL_SHADER_SOURCE_LENGTH);
    // return glGetShaderSource(shader, len);

    throw new NotImplementedException("getShaderSource() unimplemented for BGFX");
  }

  @Override
  public void getShaderPrecisionFormat(int shaderType, int precisionType, IntBuffer range, IntBuffer precision) {
    // glGetShaderPrecisionFormat(shaderType, precisionType, range, precision);
    throw new NotImplementedException("getShaderPrecisionFormat() unimplemented for BGFX");
  }

  @Override
  public void getVertexAttribfv(int index, int pname, FloatBuffer params) {
    // glGetVertexAttribfv(index, pname, params);
    throw new NotImplementedException("getVertexAttribfv() unimplemented for BGFX");
  }

  @Override
  public void getVertexAttribiv(int index, int pname, IntBuffer params) {
    // glGetVertexAttribiv(index, pname, params);
    throw new NotImplementedException("getVertexAttribiv() unimplemented for BGFX");
  }

  @Override
  public void getVertexAttribPointerv(int index, int pname, ByteBuffer data) {
    // /**
    //  * Seems to apply only to this case:
    //  * If a non-zero named buffer object was bound to the GL_ARRAY_BUFFER target
    //  * (see glBindBuffer) when the desired pointer was previously specified, the
    //  * pointer returned is a byte offset into the buffer object's data store.
    //  */
    // try (MemoryStack stack = stackPush()) {
    //   IntBuffer buf = stack.mallocInt(1);
    //   glGetIntegerv(GL_ARRAY_BUFFER_BINDING, buf);
    //   if (buf.get(0) == 0) {
    //     throw new RuntimeException("no buffer is bound to GL_ARRAY_BUFFER");
    //   }
    //   PointerBuffer pb = stack.mallocPointer(data.remaining());
    //   glGetVertexAttribPointerv(index, pname, pb);
    //   // TODO: check this
    //   ByteBuffer bb = pb.getByteBuffer(pb.position(), pb.limit());
    //   data.put(bb);
    // }

    throw new NotImplementedException("getVertexAttribPointerv() unimplemented for BGFX");
  }

  @Override
  public void getUniformfv(int program, int location, FloatBuffer params) {
    // glGetUniformfv(program, location, params);
    throw new NotImplementedException("getUniformfv() unimplemented for BGFX");
  }

  @Override
  public void getUniformiv(int program, int location, IntBuffer params) {
    // glGetUniformiv(program, location, params);
    throw new NotImplementedException("getUniformiv() unimplemented for BGFX");
  }

  @Override
  public boolean isProgram(int program) {
    // return glIsProgram(program);
    throw new NotImplementedException("isProgram() unimplemented for BGFX");
  }

  @Override
  public void getProgramiv(int program, int pname, IntBuffer params) {
    // glGetProgramiv(program, pname, params);
    throw new NotImplementedException("getProgramiv() unimplemented for BGFX");
  }

  @Override
  public String getProgramInfoLog(int program) {
    // int len = glGetProgrami(program, GL_INFO_LOG_LENGTH);
    // return glGetProgramInfoLog(program, len);

    throw new NotImplementedException("getProgramInfoLog() unimplemented for BGFX");
  }

  ///////////////////////////////////////////////////////////

  // Per-Fragment Operations

  @Override
  public void scissor(int x, int y, int w, int h) {
    // float f = graphics.pixelDensity;
    // glScissor((int)(f * x), (int)(f * y), (int)f * w, (int)(f * h));

    throw new NotImplementedException("scissor() unimplemented for BGFX");
  }

  @Override
  public void sampleCoverage(float value, boolean invert) {
    // glSampleCoverage(value, invert);
    throw new NotImplementedException("sampleCoverage() unimplemented for BGFX");
  }

  @Override
  public void stencilFunc(int func, int ref, int mask) {
    // glStencilFunc(func, ref, mask);
    throw new NotImplementedException("stencilFunc() unimplemented for BGFX");
  }

  @Override
  public void stencilFuncSeparate(int face, int func, int ref, int mask) {
    // glStencilFuncSeparate(face, func, ref, mask);
    throw new NotImplementedException("stencilFuncSeparate() unimplemented for BGFX");
  }

  @Override
  public void stencilOp(int sfail, int dpfail, int dppass) {
    // glStencilOp(sfail, dpfail, dppass);
    throw new NotImplementedException("stencilOp() unimplemented for BGFX");
  }

  @Override
  public void stencilOpSeparate(int face, int sfail, int dpfail, int dppass) {
    // glStencilOpSeparate(face, sfail, dpfail, dppass);
    throw new NotImplementedException("stencilOpSeparate() unimplemented for BGFX");
  }

  @Override
  public void depthFunc(int func) {
    // glDepthFunc(func);
    throw new NotImplementedException("depthFunc() unimplemented for BGFX");
  }

  @Override
  public void blendEquation(int mode) {
    // glBlendEquation(mode);
    throw new NotImplementedException("blendEquation() unimplemented for BGFX");
  }

  @Override
  public void blendEquationSeparate(int modeRGB, int modeAlpha) {
    // glBlendEquationSeparate(modeRGB, modeAlpha);
    throw new NotImplementedException("blendEquationSeparate() unimplemented for BGFX");
  }

  @Override
  public void blendFunc(int src, int dst) {
    // glBlendFunc(src, dst);
    throw new NotImplementedException("blendFunc() unimplemented for BGFX");
  }

  @Override
  public void blendFuncSeparate(int srcRGB, int dstRGB, int srcAlpha, int dstAlpha) {
    // glBlendFuncSeparate(srcRGB, dstRGB, srcAlpha, dstAlpha);
    throw new NotImplementedException("blendFuncSeparate() unimplemented for BGFX");
  }

  @Override
  public void blendColor(float red, float green, float blue, float alpha) {
    // glBlendColor(red, green, blue, alpha);
    throw new NotImplementedException("blendColor() unimplemented for BGFX");
  }

  ///////////////////////////////////////////////////////////

  // Whole Framebuffer Operations

  @Override
  public void colorMask(boolean r, boolean g, boolean b, boolean a) {
    // glColorMask(r, g, b, a);
    throw new NotImplementedException("colorMask() unimplemented for BGFX");
  }

  @Override
  public void depthMask(boolean mask) {
    // glDepthMask(mask);
    throw new NotImplementedException("depthMask() unimplemented for BGFX");
  }

  @Override
  public void stencilMask(int mask) {
    // glStencilMask(mask);
    throw new NotImplementedException("stencilMask() unimplemented for BGFX");
  }

  @Override
  public void stencilMaskSeparate(int face, int mask) {
    // glStencilMaskSeparate(face, mask);
    throw new NotImplementedException("stencilMaskSeparate() unimplemented for BGFX");
  }

  @Override
  public void clearColor(float r, float g, float b, float a) {
    // glClearColor(r, g, b, a);
    throw new NotImplementedException("clearColor() unimplemented for BGFX");
  }

  @Override
  public void clearDepth(float d) {
    // glClearDepth(d);
    throw new NotImplementedException("clearDepth() unimplemented for BGFX");
  }

  @Override
  public void clearStencil(int s) {
    // glClearStencil(s);
    throw new NotImplementedException("clearStencil() unimplemented for BGFX");
  }

  @Override
  public void clear(int buf) {
    // glClear(buf);
    throw new NotImplementedException("clear() unimplemented for BGFX");
  }

  ///////////////////////////////////////////////////////////

  // Framebuffers Objects

  @Override
  protected void bindFramebufferImpl(int target, int framebuffer) {
    // glBindFramebuffer(target, framebuffer);
    throw new NotImplementedException("bindFramebufferImpl() unimplemented for BGFX");
  }

  @Override
  public void deleteFramebuffers(int n, IntBuffer framebuffers) {
    // // TODO: have overload for a single framebuffer
    // //       'glDeleteFramebuffers(int framebuffer)'
    // glDeleteFramebuffers(framebuffers);

    throw new NotImplementedException("deleteFramebuffers() unimplemented for BGFX");
  }

  @Override
  public void genFramebuffers(int n, IntBuffer framebuffers) {
    // glGenFramebuffers(framebuffers);
    throw new NotImplementedException("genFramebuffers() unimplemented for BGFX");
  }

  @Override
  public void bindRenderbuffer(int target, int renderbuffer) {
    // glBindRenderbuffer(target, renderbuffer);
    throw new NotImplementedException("bindRenderbuffer() unimplemented for BGFX");
  }

  @Override
  public void deleteRenderbuffers(int n, IntBuffer renderbuffers) {
    // // TODO: have overload for a single renderbuffer
    // //       'glDeleteRenderbuffers(int renderbuffer)'
    // glDeleteRenderbuffers(renderbuffers);

    throw new NotImplementedException("deleteRenderbuffers() unimplemented for BGFX");
  }

  @Override
  public void genRenderbuffers(int n, IntBuffer renderbuffers) {
    // glGenRenderbuffers(renderbuffers);
    throw new NotImplementedException("genRenderbuffers() unimplemented for BGFX");
  }

  @Override
  public void renderbufferStorage(int target, int internalFormat, int width, int height) {
    // glRenderbufferStorage(target, internalFormat, width, height);
    throw new NotImplementedException("renderbufferStorage() unimplemented for BGFX");
  }

  @Override
  public void framebufferRenderbuffer(int target, int attachment, int rendbuferfTarget, int renderbuffer) {
    // glFramebufferRenderbuffer(target, attachment, rendbuferfTarget, renderbuffer);
    throw new NotImplementedException("framebufferRenderbuffer() unimplemented for BGFX");
  }

  @Override
  public void framebufferTexture2D(int target, int attachment, int texTarget, int texture, int level) {
    // glFramebufferTexture2D(target, attachment, texTarget, texture, level);
    throw new NotImplementedException("framebufferTexture2D() unimplemented for BGFX");
  }

  @Override
  public int checkFramebufferStatus(int target) {
    // return glCheckFramebufferStatus(target);
    throw new NotImplementedException("checkFramebufferStatus() unimplemented for BGFX");
  }

  @Override
  public boolean isFramebuffer(int framebuffer) {
    // return glIsFramebuffer(framebuffer);
    throw new NotImplementedException("isFramebuffer() unimplemented for BGFX");
  }

  @Override
  public void getFramebufferAttachmentParameteriv(int target, int attachment, int pname, IntBuffer params) {
    // glGetFramebufferAttachmentParameteriv(target, attachment, pname, params);
    throw new NotImplementedException("getFramebufferAttachmentParameteriv() unimplemented for BGFX");
  }

  @Override
  public boolean isRenderbuffer(int renderbuffer) {
    // return glIsRenderbuffer(renderbuffer);
    throw new NotImplementedException("isRenderbuffer() unimplemented for BGFX");
  }

  @Override
  public void getRenderbufferParameteriv(int target, int pname, IntBuffer params) {
    // glGetRenderbufferParameteriv(target, pname, params);
    throw new NotImplementedException("getRenderbufferParameteriv() unimplemented for BGFX");
  }

  @Override
  public void blitFramebuffer(int srcX0, int srcY0, int srcX1, int srcY1, int dstX0, int dstY0, int dstX1, int dstY1, int mask, int filter) {
    // glBlitFramebuffer(srcX0, srcY0, srcX1, srcY1, dstX0, dstY0, dstX1, dstY1, mask, filter);
    throw new NotImplementedException("blitFramebuffer() unimplemented for BGFX");
  }

  @Override
  public void renderbufferStorageMultisample(int target, int samples, int format, int width, int height) {
    // glRenderbufferStorageMultisample(target, samples, format, width, height);
    throw new NotImplementedException("renderbufferStorageMultisample() unimplemented for BGFX");
  }

  @Override
  public void readBuffer(int buf) {
    // glReadBuffer(buf);
    throw new NotImplementedException("readBuffer() unimplemented for BGFX");
  }

  @Override
  public void drawBuffer(int buf) {
    // glDrawBuffer(buf);
    throw new NotImplementedException("drawBuffer() unimplemented for BGFX");
  }


  @Override
  protected void getGL(PGL pgl) {
    // PLWJGL plwjgl = (PLWJGL)pgl;
    // setThread(plwjgl.glThread);
    // reqNumSamples = pgl.reqNumSamples;

    throw new NotImplementedException("getGL() unimplemented for BGFX");
  }


  @Override
  public Object getNative() {
    // return sketch.getSurface().getNative();
    throw new NotImplementedException("getNative() unimplemented for BGFX");
  }


  @Override
  protected void setFrameRate(float fps) {
    sketch.getSurface().setFrameRate(fps);
  }


  @Override
  protected void initSurface(int antialias) {
    // noop
  }


  @Override
  protected void reinitSurface() {
    // noop
  }


  @Override
  protected void registerListeners() {
    // noop
  }


  @Override
  protected int getDepthBits() {
    // int frameBuffer = glGetInteger(GL_FRAMEBUFFER_BINDING);
    // // Bind default framebuffer
    // glBindFramebuffer(GL_FRAMEBUFFER, 0);
    // int result = glGetFramebufferAttachmentParameteri(GL_FRAMEBUFFER, GL_DEPTH,
    //                                                   GL_FRAMEBUFFER_ATTACHMENT_DEPTH_SIZE);
    // glBindFramebuffer(GL_FRAMEBUFFER, frameBuffer);
    // return result;

    throw new NotImplementedException("getDepthBits() unimplemented for BGFX");
  }


  @Override
  protected int getStencilBits() {
    // int frameBuffer = glGetInteger(GL_FRAMEBUFFER_BINDING);
    // // Bind default framebuffer
    // glBindFramebuffer(GL_FRAMEBUFFER, 0);
    // int result = glGetFramebufferAttachmentParameteri(GL_FRAMEBUFFER, GL_STENCIL,
    //                                                   GL_FRAMEBUFFER_ATTACHMENT_STENCIL_SIZE);
    // glBindFramebuffer(GL_FRAMEBUFFER, frameBuffer);
    // return result;

    throw new NotImplementedException("getStencilBits() unimplemented for BGFX");
  }


  @Override
  protected float getPixelScale() {
    // TODO: Fractional? Make this int to fit with how PApplet does it
    return graphics.pixelDensity;
  }


  @Override
  protected boolean canDraw() {
    return true;
  }


  @Override
  protected void requestFocus() {
    // TODO: getSurface().requestFocus()
  }


  @Override
  protected void requestDraw() {
    // noop
  }


  @Override
  protected void swapBuffers() {
    // TODO: getSuface().swapBuffers();
  }


  @Override
  protected void initFBOLayer() {
    if (0 < sketch.frameCount) {
      if (isES()) initFBOLayerES();
      else initFBOLayerGL();
    }
  }


  @Override
  protected int getGLSLVersion() {
    // // https://www.khronos.org/registry/OpenGL-Refpages/gl4/html/glGetString.xhtml
    // //
    // // > The GL_VERSION and GL_SHADING_LANGUAGE_VERSION strings begin with
    // // > a version number. The version number uses one of these forms:
    // // > major_number.minor_number major_number.minor_number.release_number
    // // > Vendor-specific information may follow the version number. Its format
    // // > depends on the implementation, but a space always separates the version
    // // > number and the vendor-specific information.
    // //
    // // Example output desktop OpenGL:
    // // 4.50 - Build 24.20.100.6286
    // //
    // // Example output OpenGL ES (we shouldn't get ES if we don't request it though):
    // // OpenGL ES GLSL ES N.M vendor-specific information
    // //
    // // [jv 2018-10-08]

    // String versionVendorInfoString = glGetString(SHADING_LANGUAGE_VERSION);
    // if (versionVendorInfoString == null) {
    //   return 0;
    // }

    // String es2prefix = "OpenGL ES GLSL ES ";
    // if (versionVendorInfoString.startsWith(es2prefix)) {
    //   versionVendorInfoString = versionVendorInfoString.substring(es2prefix.length());
    // }

    // String versionString;
    // {
    //   int spaceIndex = versionVendorInfoString.indexOf(' ');
    //   int end = spaceIndex >= 0 ? spaceIndex : versionVendorInfoString.length();
    //   versionString = versionVendorInfoString.substring(0, end);
    // }

    // String[] parts = versionString.split("\\.");
    // if (parts.length >= 2) {
    //   int major = PApplet.parseInt(parts[0], 0);
    //   int minor = PApplet.parseInt(parts[1], 0);
    //   return major * 100 + minor;
    // }
    // return 0;

    throw new NotImplementedException("getGLSLVersion() unimplemented for BGFX");
  }


  @Override
  protected String getGLSLVersionSuffix() {
    // String versionVendorInfoString = glGetString(SHADING_LANGUAGE_VERSION);
    // if (versionVendorInfoString == null) {
    //   return null;
    // }

    // String es2prefix = "OpenGL ES GLSL ES ";
    // if (versionVendorInfoString.startsWith(es2prefix)) {
    //   return " es";
    // }
    // return "";

    throw new NotImplementedException("getGLSLVersionSuffix() unimplemented for BGFX");
  }

  @Override
  protected String[] loadVertexShader(String filename) {
    return loadVertexShader(filename, getGLSLVersion(), getGLSLVersionSuffix());
  }

  @Override
  protected String[] loadFragmentShader(String filename) {
    return loadFragmentShader(filename, getGLSLVersion(), getGLSLVersionSuffix());
  }

  @Override
  protected String[] loadVertexShader(URL url) {
    return loadVertexShader(url, getGLSLVersion(), getGLSLVersionSuffix());
  }

  @Override
  protected String[] loadFragmentShader(URL url) {
    return loadFragmentShader(url, getGLSLVersion(), getGLSLVersionSuffix());
  }

  @Override
  protected String[] loadFragmentShader(String filename, int version, String versionSuffix) {
    String[] fragSrc0 = sketch.loadStrings(filename);
    return preprocessFragmentSource(fragSrc0, version, versionSuffix);
  }

  @Override
  protected String[] loadVertexShader(String filename, int version, String versionSuffix) {
    String[] vertSrc0 = sketch.loadStrings(filename);
    return preprocessVertexSource(vertSrc0, version, versionSuffix);
  }

  @Override
  protected String[] loadFragmentShader(URL url, int version, String versionSuffix) {
    try {
      String[] fragSrc0 = PApplet.loadStrings(url.openStream());
      return preprocessFragmentSource(fragSrc0, version, versionSuffix);
    } catch (IOException e) {
      PGraphics.showException("Cannot load fragment shader " + url.getFile());
    }
    return null;
  }

  @Override
  protected String[] loadVertexShader(URL url, int version, String versionSuffix) {
    try {
      String[] vertSrc0 = PApplet.loadStrings(url.openStream());
      return preprocessVertexSource(vertSrc0, version, versionSuffix);
    } catch (IOException e) {
      PGraphics.showException("Cannot load vertex shader " + url.getFile());
    }
    return null;
  }

  private void initFBOLayerES() {
    IntBuffer buf = allocateDirectIntBuffer(fboWidth * fboHeight);

    if (hasReadBuffer()) readBuffer(BACK);
    readPixelsImpl(0, 0, fboWidth, fboHeight, RGBA, UNSIGNED_BYTE, buf);
    bindTexture(TEXTURE_2D, glColorTex.get(frontTex));
    texSubImage2D(TEXTURE_2D, 0, 0, 0, fboWidth, fboHeight, RGBA, UNSIGNED_BYTE, buf);

    bindTexture(TEXTURE_2D, glColorTex.get(backTex));
    texSubImage2D(TEXTURE_2D, 0, 0, 0, fboWidth, fboHeight, RGBA, UNSIGNED_BYTE, buf);

    bindTexture(TEXTURE_2D, 0);
    bindFramebufferImpl(FRAMEBUFFER, 0);
  }


  private void initFBOLayerGL() {
    // Copy the contents of the front and back screen buffers to the textures
    // of the FBO, so they are properly initialized. Note that the front buffer
    // of the default framebuffer (the screen) contains the previous frame:
    // https://www.opengl.org/wiki/Default_Framebuffer
    // so it is copied to the front texture of the FBO layer:
    if (pclearColor || 0 < pgeomCount || !sketch.isLooping()) {
      if (hasReadBuffer()) readBuffer(FRONT);
    } else {
      // ...except when the previous frame has not been cleared and nothing was
      // rendered while looping. In this case the back buffer, which holds the
      // initial state of the previous frame, still contains the most up-to-date
      // screen state.
      readBuffer(BACK);
    }
    bindFramebufferImpl(DRAW_FRAMEBUFFER, glColorFbo.get(0));
    framebufferTexture2D(FRAMEBUFFER, COLOR_ATTACHMENT0,
                         TEXTURE_2D, glColorTex.get(frontTex), 0);
    if (hasDrawBuffer()) drawBuffer(COLOR_ATTACHMENT0);
    blitFramebuffer(0, 0, fboWidth, fboHeight,
                    0, 0, fboWidth, fboHeight,
                    COLOR_BUFFER_BIT, NEAREST);

    readBuffer(BACK);
    bindFramebufferImpl(DRAW_FRAMEBUFFER, glColorFbo.get(0));
    framebufferTexture2D(FRAMEBUFFER, COLOR_ATTACHMENT0,
                         TEXTURE_2D, glColorTex.get(backTex), 0);
    drawBuffer(COLOR_ATTACHMENT0);
    blitFramebuffer(0, 0, fboWidth, fboHeight,
                    0, 0, fboWidth, fboHeight,
                    COLOR_BUFFER_BIT, NEAREST);

    bindFramebufferImpl(FRAMEBUFFER, 0);
  }

}
