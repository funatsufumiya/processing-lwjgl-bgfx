package processing.lwjgl.types;

public enum BGFXCapsFormat {
    TEXTURE_NONE(0x00000000L),
    TEXTURE_2D(0x00000001L),
    TEXTURE_2D_SRGB(0x00000002L),
    TEXTURE_2D_EMULATED(0x00000004L),
    TEXTURE_3D(0x00000008L),
    TEXTURE_3D_SRGB(0x00000010L),
    TEXTURE_3D_EMULATED(0x00000020L),
    TEXTURE_CUBE(0x00000040L),
    TEXTURE_CUBE_SRGB(0x00000080L),
    TEXTURE_CUBE_EMULATED(0x00000100L),
    TEXTURE_VERTEX(0x00000200L),
    TEXTURE_IMAGE_READ(0x00000400L),
    TEXTURE_IMAGE_WRITE(0x00000800L),
    TEXTURE_FRAMEBUFFER(0x00001000L),
    TEXTURE_FRAMEBUFFER_MSAA(0x00002000L),
    TEXTURE_MSAA(0x00004000L),
    TEXTURE_MIP_AUTOGEN(0x00008000L)
    ;

    public final long value;
    private BGFXCapsFormat(long value) {
        this.value = value;
    }
    public long getValue() {
        return value;
    }
    public long getCount() {
        return values().length;
    }
    public static BGFXCapsFormat valueOf(long value) {
        for (BGFXCapsFormat format : values()) {
            if (format.value == value) {
                return format;
            }
        }
        return null;
    }
}