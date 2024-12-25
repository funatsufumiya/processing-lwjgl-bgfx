package processing.lwjgl.internal;

public enum BGFXTextureFlag {
    MSAA_SAMPLE(0x0000000800000000L),
    RT(0x0000001000000000L),
    COMPUTE_WRITE(0x0000100000000000L),
    SRGB(0x0000200000000000L),
    BLIT_DST(0x0000400000000000L),
    READ_BACK(0x0000800000000000L),
    RT_MSAA_X2(0x0000002000000000L),
    RT_MSAA_X4(0x0000003000000000L),
    RT_MSAA_X8(0x0000004000000000L),
    RT_MSAA_X16(0x0000005000000000L),
    RT_MSAA_MASK(0x0000007000000000L),
    RT_WRITE_ONLY(0x0000008000000000L)
    ;
    public final long value;
    private BGFXTextureFlag(long value) {
        this.value = value;
    }
    public long getValue() {
        return value;
    }
    public long getCount() {
        return values().length;
    }
    public static BGFXTextureFlag valueOf(long value) {
        for (BGFXTextureFlag format : values()) {
            if (format.value == value) {
                return format;
            }
        }
        return null;
    }
}