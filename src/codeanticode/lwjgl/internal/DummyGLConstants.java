package codeanticode.lwjgl.internal;

public class DummyGLConstants {
    public static final int GL_FALSE = 0;
    public static final int GL_TRUE = 1;

    public static final int GL_INT = 0x1404;
    public static final int GL_BYTE = 0x1400;
    public static final int GL_SHORT = 0x1402;
    public static final int GL_FLOAT = 0x1406;
    public static final int GL_BOOL = 0x8B56;
    public static final int GL_UNSIGNED_INT = 0x1405;
    public static final int GL_UNSIGNED_BYTE = 0x1401;
    public static final int GL_UNSIGNED_SHORT = 0x1403;

    public static final int GL_RGB = 0x1907;
    public static final int GL_RGBA = 0x1908;
    public static final int GL_ALPHA = 0x1906;
    public static final int GL21_GL_LUMINANCE = 0x1909;
    public static final int GL21_GL_LUMINANCE_ALPHA = 0x190A;

    public static final int GL_UNSIGNED_SHORT_5_6_5 = 0x8363;
    public static final int GL_UNSIGNED_SHORT_4_4_4_4 = 0x8033;
    public static final int GL_UNSIGNED_SHORT_5_5_5_1 = 0x8034;
    
    public static final int GL_RGBA4 = 0x8056;
    public static final int GL_RGB5_A1 = 0x8057;
    public static final int GL_RGB565 = 0x8D62;
    public static final int GL_RGB8 = 0x8051;
    public static final int GL_RGBA8 = 0x8058;
    public static final int GL21_GL_ALPHA8 = 0x803C;
    
    public static final int GL_READ_ONLY = 0x88B8;
    public static final int GL_WRITE_ONLY = 0x88B9;
    public static final int GL_READ_WRITE = 0x88BA;

    public static final int GL21_GL_GENERATE_MIPMAP_HINT = 0x8192;
    public static final int GL_FASTEST = 0x1101;
    public static final int GL_NICEST = 0x1102;
    public static final int GL_DONT_CARE = 0x1100;
     
    public static final int GL_VENDOR = 0x1F00;
    public static final int GL_RENDERER = 0x1F01;
    public static final int GL_VERSION = 0x1F02;
    public static final int GL_EXTENSIONS = 0x1F03;
    public static final int GL_SHADING_LANGUAGE_VERSION = 0x8B8C;

    public static final int GL_MAX_SAMPLES = 0x8D57;
    public static final int GL_SAMPLES = 0x80A9;

    public static final int GL_ALIASED_LINE_WIDTH_RANGE = 0x846E;
    public static final int GL21_GL_ALIASED_POINT_SIZE_RANGE = 0x846D;

    public static final int GL21_GL_DEPTH_BITS = 0x0D56;
    public static final int GL21_GL_STENCIL_BITS = 0x0D57;
    
    public static final int GL_CCW = 0x0901;
    public static final int GL_CW = 0x0900;

    public static final int GL_VIEWPORT = 0x0BA2;

    public static final int GL_ARRAY_BUFFER = 0x8892;
    public static final int GL_ELEMENT_ARRAY_BUFFER = 0x8893;
    public static final int GL_PIXEL_PACK_BUFFER = 0x88EB;

    public static final int GL_MAX_VERTEX_ATTRIBS = 0x8869;

    public static final int GL_STATIC_DRAW = 0x88E4;
    public static final int GL_DYNAMIC_DRAW = 0x88E8;
    public static final int GL_STREAM_DRAW = 0x88E0;
    public static final int GL_STREAM_READ = 0x88E1;

    public static final int GL_BUFFER_SIZE = 0x8764;
    public static final int GL_BUFFER_USAGE = 0x8765;
    
    public static final int GL_POINTS = 0x0000;
    public static final int GL_LINE_STRIP = 0x0003;
    public static final int GL_LINE_LOOP = 0x0002;
    public static final int GL_LINES = 0x0001;
    public static final int GL_TRIANGLE_FAN = 0x0006;
    public static final int GL_TRIANGLE_STRIP = 0x0005;
    public static final int GL_TRIANGLES = 0x0004;

    public static final int GL_CULL_FACE = 0x0B44;
    public static final int GL_FRONT = 0x0404;
    public static final int GL_BACK = 0x0405;
    public static final int GL_FRONT_AND_BACK = 0x0408;

    public static final int GL_POLYGON_OFFSET_FILL = 0x8037;

    public static final int GL_UNPACK_ALIGNMENT = 0x0CF5;
    public static final int GL_PACK_ALIGNMENT = 0x0D05;

    public static final int GL_TEXTURE_2D = 0x0DE1;
    public static final int GL32C_GL_TEXTURE_RECTANGLE = 0x84F5;

    public static final int GL_TEXTURE_BINDING_2D = 0x8069;
    public static final int GL32C_GL_TEXTURE_BINDING_RECTANGLE = 0x84F6;

    public static final int GL_MAX_TEXTURE_SIZE = 0x0D33;
    public static final int GL_TEXTURE_MAX_ANISOTROPY = 0x84FE;
    public static final int GL_MAX_TEXTURE_MAX_ANISOTROPY = 0x84FF;

    public static final int GL_MAX_VERTEX_TEXTURE_IMAGE_UNITS = 0x8B4C;
    public static final int GL_MAX_TEXTURE_IMAGE_UNITS = 0x8872;
    public static final int GL_MAX_COMBINED_TEXTURE_IMAGE_UNITS = 0x8B4D;

    public static final int GL_NUM_COMPRESSED_TEXTURE_FORMATS = 0x86A2;
    public static final int GL_COMPRESSED_TEXTURE_FORMATS = 0x86A3;

    public static final int GL_NEAREST = 0x2600;
    public static final int GL_LINEAR = 0x2601;
    public static final int GL_LINEAR_MIPMAP_NEAREST = 0x2701;
    public static final int GL_LINEAR_MIPMAP_LINEAR = 0x2703;

    public static final int GL_CLAMP_TO_EDGE = 0x812F;
    public static final int GL_REPEAT = 0x2901;
    
    public static final int GL_TEXTURE0 = 0x84C0;
    public static final int GL_TEXTURE1 = 0x84C1;
    public static final int GL_TEXTURE2 = 0x84C2;
    public static final int GL_TEXTURE3 = 0x84C3;
    public static final int GL_TEXTURE_MIN_FILTER = 0x2801;
    public static final int GL_TEXTURE_MAG_FILTER = 0x2800;
    public static final int GL_TEXTURE_WRAP_S = 0x2802;
    public static final int GL_TEXTURE_WRAP_T = 0x2803;
    public static final int GL_TEXTURE_WRAP_R = 0x8072;

    public static final int GL_TEXTURE_CUBE_MAP = 0x8513;
    public static final int GL_TEXTURE_CUBE_MAP_POSITIVE_X = 0x8515;
    public static final int GL_TEXTURE_CUBE_MAP_POSITIVE_Y = 0x8517;
    public static final int GL_TEXTURE_CUBE_MAP_POSITIVE_Z = 0x8519;
    public static final int GL_TEXTURE_CUBE_MAP_NEGATIVE_X = 0x8516;
    public static final int GL_TEXTURE_CUBE_MAP_NEGATIVE_Y = 0x8518;
    public static final int GL_TEXTURE_CUBE_MAP_NEGATIVE_Z = 0x851A;

    public static final int GL_VERTEX_SHADER = 0x8B31;
    public static final int GL_FRAGMENT_SHADER = 0x8B30;
    public static final int GL_INFO_LOG_LENGTH = 0x8B84;
    public static final int GL_SHADER_SOURCE_LENGTH = 0x8B88;
    public static final int GL_COMPILE_STATUS = 0x8B81;
    public static final int GL_LINK_STATUS = 0x8B82;
    public static final int GL_VALIDATE_STATUS = 0x8B83;
    public static final int GL_SHADER_TYPE = 0x8B4F;
    public static final int GL_DELETE_STATUS = 0x8B80;

    public static final int GL_FLOAT_VEC2 = 0x8B50;
    public static final int GL_FLOAT_VEC3 = 0x8B51;
    public static final int GL_FLOAT_VEC4 = 0x8B52;
    public static final int GL_FLOAT_MAT2 = 0x8B5A;
    public static final int GL_FLOAT_MAT3 = 0x8B5B;
    public static final int GL_FLOAT_MAT4 = 0x8B5C;
    public static final int GL_INT_VEC2 = 0x8B53;
    public static final int GL_INT_VEC3 = 0x8B54;
    public static final int GL_INT_VEC4 = 0x8B55;
    public static final int GL_BOOL_VEC2 = 0x8B57;
    public static final int GL_BOOL_VEC3 = 0x8B58;
    public static final int GL_BOOL_VEC4 = 0x8B59;
    public static final int GL_SAMPLER_2D = 0x8B5E;
    public static final int GL_SAMPLER_CUBE = 0x8B60;

    public static final int GL_LOW_FLOAT = 0x8DF0;
    public static final int GL_MEDIUM_FLOAT = 0x8DF1;
    public static final int GL_HIGH_FLOAT = 0x8DF2;
    public static final int GL_LOW_INT = 0x8DF3;
    public static final int GL_MEDIUM_INT = 0x8DF4;
    public static final int GL_HIGH_INT = 0x8DF5;

    public static final int GL_CURRENT_VERTEX_ATTRIB = 0x8626;

    public static final int GL_VERTEX_ATTRIB_ARRAY_BUFFER_BINDING = 0x889F;
    public static final int GL_VERTEX_ATTRIB_ARRAY_ENABLED = 0x8622;
    public static final int GL_VERTEX_ATTRIB_ARRAY_SIZE = 0x8623;
    public static final int GL_VERTEX_ATTRIB_ARRAY_STRIDE = 0x8624;
    public static final int GL_VERTEX_ATTRIB_ARRAY_TYPE = 0x8625;
    public static final int GL_VERTEX_ATTRIB_ARRAY_NORMALIZED = 0x886A;
    public static final int GL_VERTEX_ATTRIB_ARRAY_POINTER = 0x8645;

    public static final int GL_BLEND = 0x0BE2;
    public static final int GL_ONE = 1;
    public static final int GL_ZERO = 0;
    public static final int GL_SRC_ALPHA = 0x0302;
    public static final int GL_DST_ALPHA = 0x0304;
    public static final int GL_ONE_MINUS_SRC_ALPHA = 0x0303;
    public static final int GL_ONE_MINUS_DST_COLOR = 0x0307;
    public static final int GL_ONE_MINUS_SRC_COLOR = 0x0301;
    public static final int GL_DST_COLOR = 0x0306;
    public static final int GL_SRC_COLOR = 0x0300;

    public static final int GL_SAMPLE_ALPHA_TO_COVERAGE = 0x809E;
    public static final int GL_SAMPLE_COVERAGE = 0x80A0;

    public static final int GL_KEEP = 0x1E00;
    public static final int GL_REPLACE = 0x1E01;
    public static final int GL_INCR = 0x1E02;
    public static final int GL_DECR = 0x1E03;
    public static final int GL_INVERT = 0x150A;
    public static final int GL_INCR_WRAP = 0x8507;
    public static final int GL_DECR_WRAP = 0x8508;
    public static final int GL_NEVER = 0x0200;
    public static final int GL_ALWAYS = 0x0207;

    public static final int GL_EQUAL = 0x0202;
    public static final int GL_LESS = 0x0201;
    public static final int GL_LEQUAL = 0x0203;
    public static final int GL_GREATER = 0x0204;
    public static final int GL_GEQUAL = 0x0206;
    public static final int GL_NOTEQUAL = 0x0205;
    
    public static final int GL_FUNC_ADD = 0x8006;
    public static final int GL_MIN = 0x8007;
    public static final int GL_MAX = 0x8008;
    public static final int GL_FUNC_REVERSE_SUBTRACT = 0x800B;
    public static final int GL_FUNC_SUBTRACT = 0x800A;

    public static final int GL_DITHER = 0x0BD0;

    public static final int GL_CONSTANT_COLOR = 0x8001;
    public static final int GL_CONSTANT_ALPHA = 0x8003;
    public static final int GL_ONE_MINUS_CONSTANT_COLOR = 0x8002;
    public static final int GL_ONE_MINUS_CONSTANT_ALPHA = 0x8004;
    public static final int GL_SRC_ALPHA_SATURATE = 0x0308;

    public static final int GL_SCISSOR_TEST = 0x0C11;
    public static final int GL_STENCIL_TEST = 0x0B90;
    public static final int GL_DEPTH_TEST = 0x0B71;
    public static final int GL_DEPTH_WRITEMASK = 0x0B72;

    public static final int GL_COLOR_BUFFER_BIT = 0x00004000;
    public static final int GL_DEPTH_BUFFER_BIT = 0x00000100;
    public static final int GL_STENCIL_BUFFER_BIT = 0x00000400;

    public static final int GL_FRAMEBUFFER = 0x8D40;
    public static final int GL_COLOR_ATTACHMENT0 = 0x8CE0;
    public static final int GL_COLOR_ATTACHMENT1 = 0x8CE1;
    public static final int GL_COLOR_ATTACHMENT2 = 0x8CE2;
    public static final int GL_COLOR_ATTACHMENT3 = 0x8CE3;
    public static final int GL_RENDERBUFFER = 0x8D41;
    public static final int GL_DEPTH_ATTACHMENT = 0x8D00;
    public static final int GL_STENCIL_ATTACHMENT = 0x8D20;
    public static final int GL_READ_FRAMEBUFFER = 0x8CA8;
    public static final int GL_DRAW_FRAMEBUFFER = 0x8CA9;

    public static final int GL_DEPTH24_STENCIL8 = 0x88F0;

    public static final int GL_DEPTH_COMPONENT = 0x1902;
    public static final int GL_DEPTH_COMPONENT16 = 0x81A5;
    public static final int GL_DEPTH_COMPONENT24 = 0x81A6;
    public static final int GL_DEPTH_COMPONENT32 = 0x81A7;

    public static final int GL_STENCIL_INDEX = 0x1901;
    public static final int GL_STENCIL_INDEX1 = 0x8D46;
    public static final int GL_STENCIL_INDEX4 = 0x8D47;
    public static final int GL_STENCIL_INDEX8 = 0x8D48;

    public static final int GL_DEPTH_STENCIL = 0x84F9;

    public static final int GL_FRAMEBUFFER_COMPLETE = 0x8CD5;
    public static final int GL_FRAMEBUFFER_UNDEFINED = 0x8219;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT = 0x8CD6;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT = 0x8CD7;
    public static final int EXTFramebufferObject_GL_FRAMEBUFFER_INCOMPLETE_DIMENSIONS_EXT = 0x8CD9;
    public static final int EXTFramebufferObject_GL_FRAMEBUFFER_INCOMPLETE_FORMATS_EXT = 0x8CDA;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_DRAW_BUFFER = 0x8CDB;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_READ_BUFFER = 0x8CDC;
    public static final int GL_FRAMEBUFFER_UNSUPPORTED = 0x8CDD;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_MULTISAMPLE = 0x8D56;
    public static final int GL32C_GL_FRAMEBUFFER_INCOMPLETE_LAYER_TARGETS = 0x8DA8;
    
    public static final int GL_FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE = 0x8CD0;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_OBJECT_NAME = 0x8CD1;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL = 0x8CD2;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_CUBE_MAP_FACE = 0x8CD3;

    public static final int GL_RENDERBUFFER_WIDTH = 0x8D42;
    public static final int GL_RENDERBUFFER_HEIGHT = 0x8D43;
    public static final int GL_RENDERBUFFER_RED_SIZE = 0x8D50;
    public static final int GL_RENDERBUFFER_GREEN_SIZE = 0x8D51;
    public static final int GL_RENDERBUFFER_BLUE_SIZE = 0x8D52;
    public static final int GL_RENDERBUFFER_ALPHA_SIZE = 0x8D53;
    public static final int GL_RENDERBUFFER_DEPTH_SIZE = 0x8D54;
    public static final int GL_RENDERBUFFER_STENCIL_SIZE = 0x8D55;
    public static final int GL_RENDERBUFFER_INTERNAL_FORMAT = 0x8D44;

    public static final int GL_MULTISAMPLE = 0x809D;
    public static final int GL_LINE_SMOOTH = 0x0B20;
    public static final int GL_POLYGON_SMOOTH = 0x0B41;

    public static final int GL_SYNC_GPU_COMMANDS_COMPLETE = 0x9117;
    public static final int GL_ALREADY_SIGNALED = 0x911A;
    public static final int GL_CONDITION_SATISFIED = 0x911C;
}