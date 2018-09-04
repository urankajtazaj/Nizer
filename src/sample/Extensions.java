package sample;

public class Extensions {

    private String[] video  = {
        "3g2",
        "3gp",
        "aaf",
        "asf",
        "avchd",
        "avi",
        "drc",
        "flv",
        "m2v",
        "m4p",
        "m4v",
        "mkv",
        "mng",
        "mov",
        "mp2",
        "mp4",
        "mpe",
        "mpeg",
        "mpg",
        "mpv",
        "mxf",
        "nsv",
        "ogg",
        "ogv",
        "ogm",
        "qt",
        "rm",
        "rmvb",
        "roq",
        "srt",
        "svi",
        "vob",
        "webm",
        "wmv",
        "yuv"
    };
    private String[] doc = { "odp", "ods", "wps", "ebook", "log", "md", "org", "pages", "wpd", "csv", "ics", "vcf", "doc", "docx", "xls", "xlsx", "ppt", "pptx", "txt", "pdf", "accdb"};
    private String[] exe    = {"exe", "apk", "cmd", "osx", "run", "vb", "vbs", "vbe", "vbscript", "scr", "pif", "msi", "lnk", "inf", "bin", "action", "app", "bat", "com", "csh", "c", "csh", "java"};
    private String[] audio  = {
        "aac",
        "aiff",
        "ape",
        "au",
        "flac",
        "gsm",
        "it",
        "m3u",
        "m4a",
        "mid",
        "mod",
        "mp3",
        "mpa",
        "pls",
        "ra",
        "s3m",
        "sid",
        "wav",
        "wma",
        "xm"
    };
    private String[] compressed = {
        "7z",
        "a",
        "ar",
        "bz2",
        "cab",
        "cpio",
        "deb",
        "dmg",
        "egg",
        "gz",
        "iso",
        "jar",
        "lha",
        "mar",
        "pea",
        "rar",
        "rpm",
        "s7z",
        "shar",
        "tar",
        "tbz2",
        "tgz",
        "tlz",
        "war",
        "whl",
        "xpi",
        "zip",
        "zipx",
        "deb",
        "rpm",
        "xz",
        "pak",
        "crx",
        "msi",
        "bin"
    };
    private String[] image = {
        "ase",
        "art",
        "bmp",
        "blp",
        "cd5",
        "cit",
        "cpt",
        "cr2",
        "cut",
        "dds",
        "dib",
        "djvu",
        "egt",
        "exif",
        "gif",
        "gpl",
        "grf",
        "icns",
        "ico",
        "iff",
        "jng",
        "jpeg",
        "jpg",
        "jfif",
        "jp2",
        "jps",
        "lbm",
        "max",
        "miff",
        "mng",
        "msp",
        "nitf",
        "ota",
        "pbm",
        "pc1",
        "pc2",
        "pc3",
        "pcf",
        "pcx",
        "pdn",
        "pgm",
        "PI1",
        "PI2",
        "PI3",
        "pict",
        "pct",
        "pnm",
        "pns",
        "ppm",
        "psb",
        "psd",
        "pdd",
        "psp",
        "px",
        "pxm",
        "pxr",
        "qfx",
        "raw",
        "rle",
        "sct",
        "sgi",
        "rgb",
        "int",
        "bw",
        "tga",
        "tiff",
        "tif",
        "vtf",
        "xbm",
        "xcf",
        "xpm",
        "3dv",
        "amf",
        "ai",
        "awg",
        "cgm",
        "cdr",
        "cmx",
        "dxf",
        "e2d",
        "egt",
        "eps",
        "fs",
        "gbr",
        "odg",
        "svg",
        "stl",
        "vrml",
        "x3d",
        "sxd",
        "v2d",
        "vnd",
        "wmf",
        "emf",
        "art",
        "xar",
        "png",
        "webp",
        "jxr",
        "hdp",
        "wdp",
        "cur",
        "ecw",
        "iff",
        "lbm",
        "liff",
        "nrrd",
        "pam",
        "pcx",
        "pgf",
        "sgi",
        "rgb",
        "rgba",
        "bw",
        "int",
        "inta",
        "sid",
        "ras",
        "sun",
        "tga"
    };

    public String[] getImages() {
        return this.image;
    }

    public String[] getVideos() {
        return this.video;
    }

    public String[] getDocs() {
        return this.doc;
    }

    public String[] getAudios() {
        return this.audio;
    }

    public String[] getExes() {
        return this.exe;
    }

    public String[] getCompressed() {
        return this.compressed;
    }
}
