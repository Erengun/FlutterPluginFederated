package com.siprix;

/**
 * Reconstructed from siprix_voip_sdk.aar 1.0.42 classes.jar.
 *
 * Fix: native method {@code setEnableVideoCall(long, boolean)} renamed to
 * {@code setVideoCallEnabled(long, boolean)} to match the JNI export in
 * libsiprix.so ({@code Java_com_siprix_IniData_setVideoCallEnabled}).
 *
 * Public API is unchanged — callers still use {@code setEnableVideoCall(boolean)}.
 *
 * @see <a href="https://github.com/siprix/FlutterPluginFederated/issues/105">upstream issue #105</a>
 */
public class IniData {

    private final long nativeHandle_;
    private String homeFolder_;
    private String brandName_;
    private boolean useProximity_;
    private boolean useTelState_;
    private boolean useVolChange_;
    private boolean use16kHzAudio_;

    public enum LogLevel {
        STACK(0), DEBUG(1), INFO(2), WARNING(3), ERROR(4), NONE(5);

        private final int value;

        LogLevel(int value) { this.value = value; }

        public int getValue() { return value; }

        public static LogLevel fromInt(int v) {
            for (LogLevel l : values()) {
                if (l.getValue() == v) return l;
            }
            return INFO;
        }
    }

    public IniData() {
        useProximity_ = true;
        useTelState_ = false;
        useVolChange_ = false;
        use16kHzAudio_ = false;
        nativeHandle_ = getDefault();
    }

    public long getHandle() { return nativeHandle_; }

    public void setLicense(String val)         { setLicense(nativeHandle_, val); }
    public void setNoCameraImgPath(String val)  { setNoCameraImgPath(nativeHandle_, val); }
    public void setLogLevelFile(LogLevel val)   { setLogLevelFile(nativeHandle_, val.getValue()); }
    public void setLogLevelIde(LogLevel val)    { setLogLevelIde(nativeHandle_, val.getValue()); }
    public void setUnregOnDestroy(boolean val)  { setUnregOnDestroy(nativeHandle_, val); }
    public void setUseDnsSrv(boolean val)       { setUseDnsSrv(nativeHandle_, val); }
    public void setRecordStereo(boolean val)    { setRecordStereo(nativeHandle_, val); }
    public void setEnableVideoCall(boolean val) { setVideoCallEnabled(nativeHandle_, val); }
    public void setTranspForceIPv4(boolean val) { setTranspForceIPv4(nativeHandle_, val); }
    public void setEnableAes128Sha32(boolean val) { setEnableAes128Sha32(nativeHandle_, val); }
    public void setEnableVUmeter(boolean val)   { setEnableVUmeter(nativeHandle_, val); }
    public void setShareUdpTransport(boolean val) { setShareUdpTransport(nativeHandle_, val); }
    public void setUseExternalRinger(boolean val) { setUseExternalRinger(nativeHandle_, val); }
    public void setTlsVerifyServer(boolean val) { setTlsVerifyServer(nativeHandle_, val); }
    public void setSingleCallMode(boolean val)  { setSingleCallMode(nativeHandle_, val); }
    public void setRtpStartPort(int val)        { setRtpStartPort(nativeHandle_, val); }
    public void addDnsServer(String val)        { addDnsServer(nativeHandle_, val); }

    public void setBrandName(String val)  { setBrandName(nativeHandle_, val); brandName_ = val; }
    public void setHomeFolder(String val) { setHomeFolder(nativeHandle_, val); homeFolder_ = val; }

    public void    setUseProximity(boolean val) { useProximity_ = val; }
    public boolean getUseProximity()            { return useProximity_; }

    public void    setUseTelState(boolean val)  { useTelState_ = val; }
    public boolean getUseTelState()             { return useTelState_; }

    public void    setUse16kHzAudio(boolean val) { use16kHzAudio_ = val; }
    public boolean getUse16kHzAudio()            { return use16kHzAudio_; }

    public void    setUseVolChange(boolean val) { useVolChange_ = val; }
    public boolean getUseVolChange()            { return useVolChange_; }

    public String getHomeFolder() { return homeFolder_; }
    public String getBrandName()  { return brandName_; }

    // --- native methods (JNI → libsiprix.so) ---

    private native long getDefault();
    private native void setLicense(long h, String val);
    private native void setHomeFolder(long h, String val);
    private native void setBrandName(long h, String val);
    private native void setLogLevelFile(long h, int val);
    private native void setLogLevelIde(long h, int val);
    private native void setUnregOnDestroy(long h, boolean val);
    private native void setUseDnsSrv(long h, boolean val);
    private native void setRecordStereo(long h, boolean val);
    private native void setVideoCallEnabled(long h, boolean val); // FIX: was setEnableVideoCall
    private native void setTranspForceIPv4(long h, boolean val);
    private native void setEnableAes128Sha32(long h, boolean val);
    private native void setEnableVUmeter(long h, boolean val);
    private native void setShareUdpTransport(long h, boolean val);
    private native void setUseExternalRinger(long h, boolean val);
    private native void setTlsVerifyServer(long h, boolean val);
    private native void setSingleCallMode(long h, boolean val);
    private native void setRtpStartPort(long h, int val);
    private native void setNoCameraImgPath(long h, String val);
    private native void addDnsServer(long h, String val);
}
