package com.aramideh.sadeq;


import com.gesmallworld.magik.commons.runtime.objects.Char16Vector;
import com.google.openlocationcode.OpenLocationCode;
import com.gesmallworld.magik.commons.interop.annotations.*;
import com.gesmallworld.magik.interop.MagikInteropUtils;

import javax.management.loading.MLet;


/**
 * The type Open location code magik.
 */
@MagikExemplar(@Name(value = "open_location_code", pkg = "user"))
public class OpenLocationCodeMagik {

    /**
     * The M open location code.
     */
    static OpenLocationCode mOpenLocationCode;
    /**
     * The M latitude.
     */
    static double mLatitude;
    /**
     * The M longitude.
     */
    static double mLongitude;
    /**
     * The M code length.
     */
    static int mCodeLength;

    /**
     * Instantiates a new Open location code magik.
     */
    public OpenLocationCodeMagik() {
    }


    /**
     * Initialize open location code magik object.
     *
     * @return the object
     */
    @ExemplarInstance
    public static Object initializeOpenLocationCodeMagik() {
        return new OpenLocationCodeMagik();
    }


    /**
     * New object.
     *
     * @param self   the self
     * @param param1 the param 1
     * @param param2 the param 2
     * @param param3 the param 3
     * @return the object
     */
    @MagikMethod("new()")
    public static Object _new(Object self, @Optional Object param1, Object param2, Object param3) {

        boolean param1_is_string = false;
        try {
            String stringVal = MagikInteropUtils.fromMagikString(param1);
            param1_is_string = true;
        } catch (IllegalArgumentException e) {
            // not an string
        }

        if (param1 != null && param1_is_string) {
            mOpenLocationCode = new OpenLocationCode(MagikInteropUtils.fromMagikString(param1));
        } else {
            mLatitude = MagikInteropUtils.fromMagikDouble(param1);
            mLongitude = MagikInteropUtils.fromMagikDouble(param2);
            mCodeLength = MagikInteropUtils.fromMagikInteger(param3, 10);
            mOpenLocationCode = new OpenLocationCode(mLatitude, mLongitude, mCodeLength);
        }

        return initializeOpenLocationCodeMagik();
    }


    /**
     * Decode object.
     *
     * @param code the code
     * @return the object
     */
    @MagikMethod("decode()")
    public final Object decode(@Optional Object code) {
        /**
         * Decodes code representing Open Location Code into OpenLocationCode.CodeArea object encapsulating latitude/longitude bounding box.
         */
        OpenLocationCode.CodeArea codeArea;
        if ( code != null ) {
            codeArea = OpenLocationCode.decode(MagikInteropUtils.fromMagikString(code));
        }else {
            codeArea = mOpenLocationCode.decode();
        }
        OpenLocationCodeAreaMagik openLocationCodeAreaMagik = new OpenLocationCodeAreaMagik();
        openLocationCodeAreaMagik.setmSouthLatitude(codeArea.getSouthLatitude());
        openLocationCodeAreaMagik.setmWestLongitude(codeArea.getWestLongitude());
        openLocationCodeAreaMagik.setmNorthLatitude(codeArea.getNorthLatitude());
        openLocationCodeAreaMagik.setmEastLongitude(codeArea.getEastLongitude());
        openLocationCodeAreaMagik.setmLength(codeArea.getLength());
        openLocationCodeAreaMagik.setmCodeArea(codeArea);

        return openLocationCodeAreaMagik;
    }


    /**
     * OpenLocationCode(double latitude, double longitude)
     * <p>
     * OpenLocationCode(double latitude, double longitude, int codeLength)
     * <p>
     * OpenLocationCode(String code)
     *
     * @param latitude   the latitude
     * @param longitude  the longitude
     * @param codeLength the code length
     * @return the object
     */
    @MagikMethod("encode()")
    public final Object encode(@Optional Object latitude, Object longitude, Object codeLength) {

        String result;

        if (latitude != null) {
            double mLatitude = MagikInteropUtils.fromMagikDouble(latitude);
            double mLongitude = MagikInteropUtils.fromMagikDouble(longitude);

            if (codeLength != null) {
                int mCodeLength = MagikInteropUtils.fromMagikInteger(codeLength);
                result = OpenLocationCode.encode(mLatitude, mLongitude, mCodeLength);
            } else {
                result = OpenLocationCode.encode(mLatitude, mLongitude);
            }
        } else {
            result = OpenLocationCode.encode(mLatitude, mLongitude, mCodeLength);
        }

        return MagikInteropUtils.toMagikString(result);

    }


    /**
     * Is full object.
     *
     * @param code the code
     * @return the object
     */
    @MagikMethod("is_full?()")
    public final Object isFull(Object code) {
        /**
         * Returns whether the provided Open Location Code is a full Open Location Code.
         */
        return MagikInteropUtils.toMagikBoolean(OpenLocationCode.isFull(MagikInteropUtils.fromMagikString(code)));
    }


    /**
     * Is full code object.
     *
     * @param code the code
     * @return the object
     */
    @MagikMethod("is_full_code?()")
    public final Object isFullCode(Object code) {
        /**
         * Returns if the code is a valid full Open Location Code.
         */
        return MagikInteropUtils.toMagikBoolean(OpenLocationCode.isFullCode(MagikInteropUtils.fromMagikString(code)));
    }

    /**
     * Is padded object.
     *
     * @param code the code
     * @return the object
     */
    @MagikMethod("is_padded?()")
    public final Object isPadded(Object code) {
        /**
         * Returns whether the provided Open Location Code is a padded Open Location Code, meaning that it contains less than 8 valid digits.
         */
        return MagikInteropUtils.toMagikBoolean(OpenLocationCode.isPadded(MagikInteropUtils.fromMagikString(code)));
    }


    /**
     * Is short object.
     *
     * @param code the code
     * @return the object
     */
    @MagikMethod("is_short?()")
    public final Object isShort(Object code) {
        /**
         * Returns whether the provided Open Location Code is a short Open Location Code.
         */
        return MagikInteropUtils.toMagikBoolean(OpenLocationCode.isShort(MagikInteropUtils.fromMagikString(code)));
    }


    /**
     * Is short code object.
     *
     * @param code the code
     * @return the object
     */
    @MagikMethod("is_short_code?()")
    public final Object isShortCode(Object code) {
        /**
         * Returns if the code is a valid short Open Location Code.
         */
        return MagikInteropUtils.toMagikBoolean(OpenLocationCode.isShortCode(MagikInteropUtils.fromMagikString(code)));
    }

    /**
     * Is valid code object.
     *
     * @param code the code
     * @return the object
     */
    @MagikMethod("is_valid_code?()")
    public final Object isValidCode(Object code) {
        /**
         * Returns whether the provided string is a valid Open Location code.
         */
        return MagikInteropUtils.toMagikBoolean(OpenLocationCode.isValidCode(MagikInteropUtils.fromMagikString(code)));
    }


    /**
     * Contains object.
     *
     * @param latitude  the latitude
     * @param longitude the longitude
     * @return the object
     */
    @MagikMethod("contains?()")
    public final Object contains(Object latitude, Object longitude) {
        /**
         * Returns whether the bounding box specified by the Open Location Code contains provided point.
         */
        return mOpenLocationCode.contains(MagikInteropUtils.fromMagikDouble(latitude), MagikInteropUtils.fromMagikDouble(longitude));
    }

    /**
     * Gets latitude.
     *
     * @return the latitude
     */
    @MagikMethod("get_latitude()")
    public final Object getLatitude() {
        return MagikInteropUtils.toMagikDouble(mLatitude);
    }

    /**
     * Sets latitude.
     *
     * @param mLatitude the m latitude
     */
    @MagikMethod("set_latitude()")
    public final void setmLatitude(Object mLatitude) {
        OpenLocationCodeMagik.mLatitude = MagikInteropUtils.fromMagikDouble(mLatitude);
    }

    /**
     * Gets longitude.
     *
     * @return the longitude
     */
    @MagikMethod("get_longitude()")
    public final Object getmLongitude() {
        return MagikInteropUtils.toMagikDouble(mLongitude);
    }

    /**
     * Sets longitude.
     *
     * @param mLongitude the m longitude
     */
    @MagikMethod("set_longitude()")
    public final void setmLongitude(double mLongitude) {
        OpenLocationCodeMagik.mLongitude = MagikInteropUtils.fromMagikDouble(mLongitude);
    }

    /**
     * Gets code length.
     *
     * @return the code length
     */
    @MagikMethod("get_code_length()")
    public final Object getmCodeLength() {
        return MagikInteropUtils.toMagikInteger(mCodeLength);
    }

    /**
     * Sets code length.
     *
     * @param mCodeLength the m code length
     */
    @MagikMethod("set_code_length()")
    public final void setmCodeLength(int mCodeLength) {
        OpenLocationCodeMagik.mCodeLength = MagikInteropUtils.fromMagikInteger(mCodeLength);
    }


}
