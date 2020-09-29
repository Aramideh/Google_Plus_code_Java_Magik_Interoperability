package com.aramideh.sadeq;


import com.gesmallworld.magik.commons.interop.annotations.ExemplarInstance;
import com.gesmallworld.magik.commons.interop.annotations.MagikExemplar;
import com.gesmallworld.magik.commons.interop.annotations.MagikMethod;
import com.gesmallworld.magik.commons.interop.annotations.Name;
import com.gesmallworld.magik.interop.MagikInteropUtils;
import com.google.openlocationcode.OpenLocationCode;


/**
 * The type Open location code area magik.
 */
@MagikExemplar(@Name(value = "open_location_code_area", pkg = "user"))
public class OpenLocationCodeAreaMagik {

    /**
     * The M south latitude.
     */
    static double mSouthLatitude;

    /**
     * The M west longitude.
     */
    static double mWestLongitude;
    /**
     * The M north latitude.
     */
    static double mNorthLatitude;
    /**
     * The M east longitude.
     */
    static double mEastLongitude;
    /**
     * The M length.
     */
    static int mLength;
    /**
     * The M code area.
     */
    static OpenLocationCode.CodeArea mCodeArea;

    /**
     * Instantiates a new Open location code area magik.
     */
    public OpenLocationCodeAreaMagik() {
    }

    /**
     * Initialize open location code area magik object.
     *
     * @return the object
     */
    @ExemplarInstance
    public static Object initializeOpenLocationCodeAreaMagik() {
        return new OpenLocationCodeAreaMagik();
    }


    /**
     * New object.
     *
     * @param self          the self
     * @param southLatitude the south latitude
     * @param westLongitude the west longitude
     * @param northLatitude the north latitude
     * @param eastLongitude the east longitude
     * @param length        the length
     * @return the object
     */
    @MagikMethod("new()")
    public static Object _new(Object self ,
                              Object southLatitude ,
                              Object westLongitude ,
                              Object northLatitude ,
                              Object eastLongitude ,
                              Object length) {

        mSouthLatitude = MagikInteropUtils.fromMagikDouble( southLatitude);
        mWestLongitude = MagikInteropUtils.fromMagikDouble( westLongitude);
        mNorthLatitude = MagikInteropUtils.fromMagikDouble( northLatitude);
        mEastLongitude = MagikInteropUtils.fromMagikDouble( eastLongitude);
        mLength = MagikInteropUtils.fromMagikInteger( length );

        mCodeArea = new OpenLocationCode.CodeArea( mSouthLatitude , mWestLongitude , mNorthLatitude , mEastLongitude , mLength);

        return initializeOpenLocationCodeAreaMagik( );
    }


    /**
     * Gets south latitude.
     *
     * @return the south latitude
     */
    @MagikMethod("get_south_latitude()")
    public final Object getmSouthLatitude() {
        return MagikInteropUtils.toMagikDouble( mCodeArea.getSouthLatitude() );
    }

    /**
     * Gets west longitude.
     *
     * @return the west longitude
     */
    @MagikMethod("get_west_longitude()")
    public final Object getmWestLongitude() {
        return MagikInteropUtils.toMagikDouble(mCodeArea.getWestLongitude());
    }


    /**
     * Gets north latitude.
     *
     * @return the north latitude
     */
    @MagikMethod("get_north_latitude()")
    public final Object getmNorthLatitude() {
        return MagikInteropUtils.toMagikDouble( mCodeArea.getNorthLatitude());
    }

    /**
     * Gets east longitude.
     *
     * @return the east longitude
     */
    @MagikMethod("get_east_longitude()")
    public final Object getmEastLongitude() {
        return MagikInteropUtils.toMagikDouble( mCodeArea.getEastLongitude());
    }

    /**
     * Gets length.
     *
     * @return the length
     */
    @MagikMethod("get_length()")
    public final Object getmLength() {
        return MagikInteropUtils.toMagikInteger( mCodeArea.getLength() );
    }


    /**
     * Sets south latitude.
     *
     * @param mSouthLatitude the m south latitude
     */
    public static void setmSouthLatitude(double mSouthLatitude) {
        OpenLocationCodeAreaMagik.mSouthLatitude = mSouthLatitude;
    }

    /**
     * Sets west longitude.
     *
     * @param mWestLongitude the m west longitude
     */
    public static void setmWestLongitude(double mWestLongitude) {
        OpenLocationCodeAreaMagik.mWestLongitude = mWestLongitude;
    }

    /**
     * Sets north latitude.
     *
     * @param mNorthLatitude the m north latitude
     */
    public static void setmNorthLatitude(double mNorthLatitude) {
        OpenLocationCodeAreaMagik.mNorthLatitude = mNorthLatitude;
    }

    /**
     * Sets east longitude.
     *
     * @param mEastLongitude the m east longitude
     */
    public static void setmEastLongitude(double mEastLongitude) {
        OpenLocationCodeAreaMagik.mEastLongitude = mEastLongitude;
    }

    /**
     * Sets length.
     *
     * @param mLength the m length
     */
    public static void setmLength(int mLength) {
        OpenLocationCodeAreaMagik.mLength = mLength;
    }


    /**
     * Sets code area.
     *
     * @param mCodeArea the m code area
     */
    public static void setmCodeArea(OpenLocationCode.CodeArea mCodeArea) {
        OpenLocationCodeAreaMagik.mCodeArea = mCodeArea;
    }

    /**
     * Gets center latitude.
     *
     * @return the center latitude
     */
    @MagikMethod("get_center_latitude()")
    public final Object getCenterLatitude() {
        return MagikInteropUtils.toMagikDouble( mCodeArea.getCenterLatitude() );
    }


    /**
     * Gets center longitude.
     *
     * @return the center longitude
     */
    @MagikMethod("get_center_longitude()")
    public final Object getCenterLongitude() {
        return MagikInteropUtils.toMagikDouble( mCodeArea.getCenterLongitude() );
    }


    /**
     * Gets latitude height.
     *
     * @return the latitude height
     */
    @MagikMethod("get_latitude_height()")
    public final Object getLatitudeHeight() {
        return MagikInteropUtils.toMagikDouble( mCodeArea.getLatitudeHeight() );
    }

    /**
     * Gets longitude width.
     *
     * @return the longitude width
     */
    @MagikMethod("get_longitude_width()")
    public final Object getLongitudeWidth() {
        return MagikInteropUtils.toMagikDouble( mCodeArea.getLongitudeWidth() );
    }

}
