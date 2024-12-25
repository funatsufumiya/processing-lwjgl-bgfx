package processing.lwjgl.internal;

public enum BGFXTextureFormat {
    BC1(0), // DXT1 R5G6B5A1
    BC2(1), // DXT3 R5G6B5A4
    BC3(2), // DXT5 R5G6B5A8
    BC4(3), // LATC1/ATI1 R8
    BC5(4), // LATC2/ATI2 RG8
    BC6H(5), // BC6H RGB16F
    BC7(6), // BC7 RGB 4-7 bits per color channel, 0-8 bits alpha
    ETC1(7), // ETC1 RGB8
    ETC2(8), // ETC2 RGB8
    ETC2A(9), // ETC2 RGBA8
    ETC2A1(10), // ETC2 RGB8A1
    PTC12(11), // PVRTC1 RGB 2BPP
    PTC14(12), // PVRTC1 RGB 4BPP
    PTC12A(13), // PVRTC1 RGBA 2BPP
    PTC14A(14), // PVRTC1 RGBA 4BPP
    PTC22(15), // PVRTC2 RGBA 2BPP
    PTC24(16), // PVRTC2 RGBA 4BPP
    ATC(17), // ATC RGB 4BPP
    ATCE(18), // ATCE RGBA 8 BPP explicit alpha
    ATCI(19), // ATCI RGBA 8 BPP interpolated alpha
    ASTC4X4(20), // ASTC 4x4 8.0 BPP
    ASTC5X4(21), // ASTC 5x4 6.40 BPP
    ASTC5X5(22), // ASTC 5x5 5.12 BPP
    ASTC6X5(23), // ASTC 6x5 4.27 BPP
    ASTC6X6(24), // ASTC 6x6 3.56 BPP
    ASTC8X5(25), // ASTC 8x5 3.20 BPP
    ASTC8X6(26), // ASTC 8x6 2.67 BPP
    ASTC8X8(27), // ASTC 8x8 2.00 BPP
    ASTC10X5(28), // ASTC 10x5 2.56 BPP
    ASTC10X6(29), // ASTC 10x6 2.13 BPP
    ASTC10X8(30), // ASTC 10x8 1.60 BPP
    ASTC10X10(31), // ASTC 10x10 1.28 BPP
    ASTC12X10(32), // ASTC 12x10 1.07 BPP
    ASTC12X12(33), // ASTC 12x12 0.89 BPP
    UNKNOWN(34), // Compressed formats above.
    R1(35),
    A8(36),
    R8(37),
    R8I(38),
    R8U(39),
    R8S(40),
    R16(41),
    R16I(42),
    R16U(43),
    R16F(44),
    R16S(45),
    R32I(46),
    R32U(47),
    R32F(48),
    RG8(49),
    RG8I(50),
    RG8U(51),
    RG8S(52),
    RG16(53),
    RG16I(54),
    RG16U(55),
    RG16F(56),
    RG16S(57),
    RG32I(58),
    RG32U(59),
    RG32F(60),
    RGB8(61),
    RGB8I(62),
    RGB8U(63),
    RGB8S(64),
    RGB9E5F(65),
    BGRA8(66),
    RGBA8(67),
    RGBA8I(68),
    RGBA8U(69),
    RGBA8S(70),
    RGBA16(71),
    RGBA16I(72),
    RGBA16U(73),
    RGBA16F(74),
    RGBA16S(75),
    RGBA32I(76),
    RGBA32U(77),
    RGBA32F(78),
    B5G6R5(79),
    R5G6B5(80),
    BGRA4(81),
    RGBA4(82),
    BGR5A1(83),
    RGB5A1(84),
    RGB10A2(85),
    RG11B10F(86),
    UNKNOWNDEPTH(87), // Depth formats below.
    D16(88),
    D24(89),
    D24S8(90),
    D32(91),
    D16F(92),
    D24F(93),
    D32F(94),
    D0S8(95)
    ;

    public final int value;
    private BGFXTextureFormat(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
    public int getCount() {
        return values().length;
    }
    public static BGFXTextureFormat valueOf(int value) {
        for (BGFXTextureFormat format : values()) {
            if (format.value == value) {
                return format;
            }
        }
        return null;
    }
}