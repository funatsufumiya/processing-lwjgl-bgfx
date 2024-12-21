package codeanticode.lwjgl.internal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DummyGLConstantsNames {
    protected DummyGLConstantsNames() {
        initMap();
    }

    protected static DummyGLConstantsNames _singleton = new DummyGLConstantsNames();
    protected static DummyGLConstantsNames getSingleton() {
        return _singleton;
    }
    protected Map<Integer, String> names = new HashMap<Integer, String>();
    // protected Map<Integer, List<String>> names = new HashMap<Integer, List<String>>();
    protected void addName(int val, String name){
        if (!names.containsKey(val)){
            // names.put(val, new ArrayList<String>());
            names.put(val, name);
        }else{
            // names.get(val).add(name);
            names.put(val, names.get(val) + " or " + name);
        }
        // System.out.println("addName: " + val + " = " + name);
    }
    protected void initMap(){
        addName(0, "GL_FALSE");
        addName(1, "GL_TRUE");

        addName(0x1404, "GL_INT");
        addName(0x1400, "GL_BYTE");
        addName(0x1402, "GL_SHORT");
        addName(0x1406, "GL_FLOAT");
        addName(0x8B56, "GL_BOOL");
        addName(0x1405, "GL_UNSIGNED_INT");
        addName(0x1401, "GL_UNSIGNED_BYTE");
        addName(0x1403, "GL_UNSIGNED_SHORT");

        addName(0x1907, "GL_RGB");
        addName(0x1908, "GL_RGBA");
        addName(0x1906, "GL_ALPHA");
        addName(0x1909, "GL21_GL_LUMINANCE");
        addName(0x190A, "GL21_GL_LUMINANCE_ALPHA");

        addName(0x8363, "GL_UNSIGNED_SHORT_5_6_5");
        addName(0x8033, "GL_UNSIGNED_SHORT_4_4_4_4");
        addName(0x8034, "GL_UNSIGNED_SHORT_5_5_5_1");
        
        addName(0x8056, "GL_RGBA4");
        addName(0x8057, "GL_RGB5_A1");
        addName(0x8D62, "GL_RGB565");
        addName(0x8051, "GL_RGB8");
        addName(0x8058, "GL_RGBA8");
        addName(0x803C, "GL21_GL_ALPHA8");
        
        addName(0x88B8, "GL_READ_ONLY");
        addName(0x88B9, "GL_WRITE_ONLY");
        addName(0x88BA, "GL_READ_WRITE");

        addName(0x8192, "GL21_GL_GENERATE_MIPMAP_HINT");
        addName(0x1101, "GL_FASTEST");
        addName(0x1102, "GL_NICEST");
        addName(0x1100, "GL_DONT_CARE");

        addName(0x1F00, "GL_VENDOR");
        addName(0x1F01, "GL_RENDERER");
        addName(0x1F02, "GL_VERSION");
        addName(0x1F03, "GL_EXTENSIONS");
        addName(0x8B8C, "GL_SHADING_LANGUAGE_VERSION");

        addName(0x8D57, "GL_MAX_SAMPLES");
        addName(0x80A9, "GL_SAMPLES");

        addName(0x846E, "GL_ALIASED_LINE_WIDTH_RANGE");
        addName(0x846D, "GL21_GL_ALIASED_POINT_SIZE_RANGE");

        addName(0x0D56, "GL21_GL_DEPTH_BITS");
        addName(0x0D57, "GL21_GL_STENCIL_BITS");

        addName(0x0901, "GL_CCW");
        addName(0x0900, "GL_CW");

        addName(0x0BA2, "GL_VIEWPORT");

        addName(0x8892, "GL_ARRAY_BUFFER");
        addName(0x8893, "GL_ELEMENT_ARRAY_BUFFER");
        addName(0x88EB, "GL_PIXEL_PACK_BUFFER");

        addName(0x8869, "GL_MAX_VERTEX_ATTRIBS");

        addName(0x88E4, "GL_STATIC_DRAW");
        addName(0x88E8, "GL_DYNAMIC_DRAW");
        addName(0x88E0, "GL_STREAM_DRAW");
        addName(0x88E1, "GL_STREAM_READ");

        addName(0x8764, "GL_BUFFER_SIZE");
        addName(0x8765, "GL_BUFFER_USAGE");

        addName(0x0000, "GL_POINTS");
        addName(0x0003, "GL_LINE_STRIP");
        addName(0x0002, "GL_LINE_LOOP");
        addName(0x0001, "GL_LINES");
        addName(0x0006, "GL_TRIANGLE_FAN");
        addName(0x0005, "GL_TRIANGLE_STRIP");
        addName(0x0004, "GL_TRIANGLES");
        
        addName(0x0B44, "GL_CULL_FACE");
        addName(0x0404, "GL_FRONT");
        addName(0x0405, "GL_BACK");
        addName(0x0408, "GL_FRONT_AND_BACK");

        addName(0x8037, "GL_POLYGON_OFFSET_FILL");

        addName(0x0CF5, "GL_UNPACK_ALIGNMENT");
        addName(0x0D05, "GL_PACK_ALIGNMENT");

        addName(0x0DE1, "GL_TEXTURE_2D");
        addName(0x84F5, "GL32C_GL_TEXTURE_RECTANGLE");

        addName(0x8069, "GL_TEXTURE_BINDING_2D");
        addName(0x84F6, "GL32C_GL_TEXTURE_BINDING_RECTANGLE");

        addName(0x0D33, "GL_MAX_TEXTURE_SIZE");
        addName(0x84FE, "GL_TEXTURE_MAX_ANISOTROPY");
        addName(0x84FF, "GL_MAX_TEXTURE_MAX_ANISOTROPY");

        addName(0x8B4C, "GL_MAX_VERTEX_TEXTURE_IMAGE_UNITS");
        addName(0x8872, "GL_MAX_TEXTURE_IMAGE_UNITS");
        addName(0x8B4D, "GL_MAX_COMBINED_TEXTURE_IMAGE_UNITS");

        addName(0x86A2, "GL_NUM_COMPRESSED_TEXTURE_FORMATS");
        addName(0x86A3, "GL_COMPRESSED_TEXTURE_FORMATS");

        addName(0x2600, "GL_NEAREST");
        addName(0x2601, "GL_LINEAR");
        addName(0x2701, "GL_LINEAR_MIPMAP_NEAREST");
        addName(0x2703, "GL_LINEAR_MIPMAP_LINEAR");

        addName(0x812F, "GL_CLAMP_TO_EDGE");
        addName(0x2901, "GL_REPEAT");

        addName(0x84C0, "GL_TEXTURE0");
        addName(0x84C1, "GL_TEXTURE1");
        addName(0x84C2, "GL_TEXTURE2");
        addName(0x84C3, "GL_TEXTURE3");
        addName(0x2801, "GL_TEXTURE_MIN_FILTER");
        addName(0x2800, "GL_TEXTURE_MAG_FILTER");
        addName(0x2802, "GL_TEXTURE_WRAP_S");
        addName(0x2803, "GL_TEXTURE_WRAP_T");
        addName(0x8072, "GL_TEXTURE_WRAP_R");

        addName(0x8513, "GL_TEXTURE_CUBE_MAP");
        addName(0x8515, "GL_TEXTURE_CUBE_MAP_POSITIVE_X");
        addName(0x8517, "GL_TEXTURE_CUBE_MAP_POSITIVE_Y");
        addName(0x8519, "GL_TEXTURE_CUBE_MAP_POSITIVE_Z");
        addName(0x8516, "GL_TEXTURE_CUBE_MAP_NEGATIVE_X");
        addName(0x8518, "GL_TEXTURE_CUBE_MAP_NEGATIVE_Y");
        addName(0x851A, "GL_TEXTURE_CUBE_MAP_NEGATIVE_Z");

        addName(0x8B31, "GL_VERTEX_SHADER");
        addName(0x8B30, "GL_FRAGMENT_SHADER");
        addName(0x8B84, "GL_INFO_LOG_LENGTH");
        addName(0x8B88, "GL_SHADER_SOURCE_LENGTH");
        addName(0x8B81, "GL_COMPILE_STATUS");
        addName(0x8B82, "GL_LINK_STATUS");
        addName(0x8B83, "GL_VALIDATE_STATUS");
        addName(0x8B4F, "GL_SHADER_TYPE");
        addName(0x8B80, "GL_DELETE_STATUS");

        addName(0x8B50, "GL_FLOAT_VEC2");
        addName(0x8B51, "GL_FLOAT_VEC3");
        addName(0x8B52, "GL_FLOAT_VEC4");
        addName(0x8B5A, "GL_FLOAT_MAT2");
        addName(0x8B5B, "GL_FLOAT_MAT3");
        addName(0x8B5C, "GL_FLOAT_MAT4");
        addName(0x8B53, "GL_INT_VEC2");
        addName(0x8B54, "GL_INT_VEC3");
        addName(0x8B55, "GL_INT_VEC4");
        addName(0x8B57, "GL_BOOL_VEC2");
        addName(0x8B58, "GL_BOOL_VEC3");
        addName(0x8B59, "GL_BOOL_VEC4");
        addName(0x8B5E, "GL_SAMPLER_2D");
        addName(0x8B60, "GL_SAMPLER_CUBE");

        addName(0x8DF0, "GL_LOW_FLOAT");
        addName(0x8DF1, "GL_MEDIUM_FLOAT");
        addName(0x8DF2, "GL_HIGH_FLOAT");
        addName(0x8DF3, "GL_LOW_INT");
        addName(0x8DF4, "GL_MEDIUM_INT");
        addName(0x8DF5, "GL_HIGH_INT");

        addName(0x8626, "GL_CURRENT_VERTEX_ATTRIB");

        addName(0x889F, "GL_VERTEX_ATTRIB_ARRAY_BUFFER_BINDING");
        addName(0x8622, "GL_VERTEX_ATTRIB_ARRAY_ENABLED");
        addName(0x8623, "GL_VERTEX_ATTRIB_ARRAY_SIZE");
        addName(0x8624, "GL_VERTEX_ATTRIB_ARRAY_STRIDE");
        addName(0x8625, "GL_VERTEX_ATTRIB_ARRAY_TYPE");
        addName(0x886A, "GL_VERTEX_ATTRIB_ARRAY_NORMALIZED");
        addName(0x8645, "GL_VERTEX_ATTRIB_ARRAY_POINTER");

        addName(0x0BE2, "GL_BLEND");
        addName(1, "GL_ONE");
        addName(0, "GL_ZERO");
        addName(0x0302, "GL_SRC_ALPHA");
        addName(0x0304, "GL_DST_ALPHA");
        addName(0x0303, "GL_ONE_MINUS_SRC_ALPHA");
        addName(0x0307, "GL_ONE_MINUS_DST_COLOR");
        addName(0x0301, "GL_ONE_MINUS_SRC_COLOR");
        addName(0x0306, "GL_DST_COLOR");
        addName(0x0300, "GL_SRC_COLOR");

        addName(0x809E, "GL_SAMPLE_ALPHA_TO_COVERAGE");
        addName(0x80A0, "GL_SAMPLE_COVERAGE");

        addName(0x1E00, "GL_KEEP");
        addName(0x1E01, "GL_REPLACE");
        addName(0x1E02, "GL_INCR");
        addName(0x1E03, "GL_DECR");
        addName(0x150A, "GL_INVERT");
        addName(0x8507, "GL_INCR_WRAP");
        addName(0x8508, "GL_DECR_WRAP");
        addName(0x0200, "GL_NEVER");
        addName(0x0207, "GL_ALWAYS");

        addName(0x0202, "GL_EQUAL");
        addName(0x0201, "GL_LESS");
        addName(0x0203, "GL_LEQUAL");
        addName(0x0204, "GL_GREATER");
        addName(0x0206, "GL_GEQUAL");
        addName(0x0205, "GL_NOTEQUAL");

        addName(0x8006, "GL_FUNC_ADD");
        addName(0x8007, "GL_MIN");
        addName(0x8008, "GL_MAX");
        addName(0x800B, "GL_FUNC_REVERSE_SUBTRACT");
        addName(0x800A, "GL_FUNC_SUBTRACT");

        addName(0x0BD0, "GL_DITHER");

        addName(0x8001, "GL_CONSTANT_COLOR");
        addName(0x8003, "GL_CONSTANT_ALPHA");
        addName(0x8002, "GL_ONE_MINUS_CONSTANT_COLOR");
        addName(0x8004, "GL_ONE_MINUS_CONSTANT_ALPHA");
        addName(0x0308, "GL_SRC_ALPHA_SATURATE");

        addName(0x0C11, "GL_SCISSOR_TEST");
        addName(0x0B90, "GL_STENCIL_TEST");
        addName(0x0B71, "GL_DEPTH_TEST");
        addName(0x0B72, "GL_DEPTH_WRITEMASK");

        addName(0x00004000, "GL_COLOR_BUFFER_BIT");
        addName(0x00000100, "GL_DEPTH_BUFFER_BIT");
        addName(0x00000400, "GL_STENCIL_BUFFER_BIT");

        addName(0x8D40, "GL_FRAMEBUFFER");
        addName(0x8CE0, "GL_COLOR_ATTACHMENT0");
        addName(0x8CE1, "GL_COLOR_ATTACHMENT1");
        addName(0x8CE2, "GL_COLOR_ATTACHMENT2");
        addName(0x8CE3, "GL_COLOR_ATTACHMENT3");
        addName(0x8D41, "GL_RENDERBUFFER");
        addName(0x8D00, "GL_DEPTH_ATTACHMENT");
        addName(0x8D20, "GL_STENCIL_ATTACHMENT");
        addName(0x8CA8, "GL_READ_FRAMEBUFFER");
        addName(0x8CA9, "GL_DRAW_FRAMEBUFFER");

        addName(0x88F0, "GL_DEPTH24_STENCIL8");

        addName(0x1902, "GL_DEPTH_COMPONENT");
        addName(0x81A5, "GL_DEPTH_COMPONENT16");
        addName(0x81A6, "GL_DEPTH_COMPONENT24");
        addName(0x81A7, "GL_DEPTH_COMPONENT32");

        addName(0x1901, "GL_STENCIL_INDEX");
        addName(0x8D46, "GL_STENCIL_INDEX1");
        addName(0x8D47, "GL_STENCIL_INDEX4");
        addName(0x8D48, "GL_STENCIL_INDEX8");

        addName(0x84F9, "GL_DEPTH_STENCIL");

        addName(0x8CD5, "GL_FRAMEBUFFER_COMPLETE");
        addName(0x8219, "GL_FRAMEBUFFER_UNDEFINED");
        addName(0x8CD6, "GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT");
        addName(0x8CD7, "GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT");
        addName(0x8CD9, "EXTFramebufferObject_GL_FRAMEBUFFER_INCOMPLETE_DIMENSIONS_EXT");
        addName(0x8CDA, "EXTFramebufferObject_GL_FRAMEBUFFER_INCOMPLETE_FORMATS_EXT");
        addName(0x8CDB, "GL_FRAMEBUFFER_INCOMPLETE_DRAW_BUFFER");
        addName(0x8CDC, "GL_FRAMEBUFFER_INCOMPLETE_READ_BUFFER");
        addName(0x8CDD, "GL_FRAMEBUFFER_UNSUPPORTED");
        addName(0x8D56, "GL_FRAMEBUFFER_INCOMPLETE_MULTISAMPLE");
        addName(0x8DA8, "GL32C_GL_FRAMEBUFFER_INCOMPLETE_LAYER_TARGETS");

        addName(0x8CD0, "GL_FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE");
        addName(0x8CD1, "GL_FRAMEBUFFER_ATTACHMENT_OBJECT_NAME");
        addName(0x8CD2, "GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL");
        addName(0x8CD3, "GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_CUBE_MAP_FACE");

        addName(0x8D42, "GL_RENDERBUFFER_WIDTH");
        addName(0x8D43, "GL_RENDERBUFFER_HEIGHT");
        addName(0x8D50, "GL_RENDERBUFFER_RED_SIZE");
        addName(0x8D51, "GL_RENDERBUFFER_GREEN_SIZE");
        addName(0x8D52, "GL_RENDERBUFFER_BLUE_SIZE");
        addName(0x8D53, "GL_RENDERBUFFER_ALPHA_SIZE");
        addName(0x8D54, "GL_RENDERBUFFER_DEPTH_SIZE");
        addName(0x8D55, "GL_RENDERBUFFER_STENCIL_SIZE");
        addName(0x8D44, "GL_RENDERBUFFER_INTERNAL_FORMAT");

        addName(0x809D, "GL_MULTISAMPLE");
        addName(0x0B20, "GL_LINE_SMOOTH");
        addName(0x0B41, "GL_POLYGON_SMOOTH");

        addName(0x9117, "GL_SYNC_GPU_COMMANDS_COMPLETE");
        addName(0x911A, "GL_ALREADY_SIGNALED");
        addName(0x911C, "GL_CONDITION_SATISFIED");
    }

    protected String getNameImpl(int value) {
        return names.getOrDefault(value, "Unknown constant: 0x" + Integer.toHexString(value));

        // List<String> list = names.get(value);
        // if (list == null || list.isEmpty()) {
        //     return "Unknown constant: 0x" + Integer.toHexString(value);
        // }

        // if (list.size() == 1) {
        //     return list.get(0);
        // }else{
        //     // join all names with " or "
        //     StringBuilder sb = new StringBuilder();
        //     for (String name : list) {
        //         if (sb.length() > 0) {
        //             sb.append(" or ");
        //         }
        //         sb.append(name);
        //         // System.out.println("name: " + name);
        //     }
        //     return sb.toString();
        // }

        // throw new RuntimeException("unreachable");
    }

    public static String getName(int value) {
        return getSingleton().getNameImpl(value);
    }
}