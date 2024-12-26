package processing.lwjgl.types;

public enum BGFXAttrib {
    POSITION(0),
    NORMAL(1),
    TANGENT(2),
    BITANGENT(3),
    COLOR0(4),
    COLOR1(5),
    COLOR2(6),
    COLOR3(7),
    INDICES(8),
    WEIGHT(9),
    TEXCOORD0(10),
    TEXCOORD1(11),
    TEXCOORD2(12),
    TEXCOORD3(13),
    TEXCOORD4(14),
    TEXCOORD5(15),
    TEXCOORD6(16),
    TEXCOORD7(17)
    ;
    public final int value;
    private BGFXAttrib(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
    public int getCount() {
        return values().length;
    }
    public static BGFXAttrib valueOf(int value) {
        for (BGFXAttrib format : values()) {
            if (format.value == value) {
                return format;
            }
        }
        return null;
    }
}