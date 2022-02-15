package com.example.mycoronav.vo2

import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml

@Xml
data class Item(
//    @PropertyElement
//    var XPos: Int?,
//    @PropertyElement
//    var XPosWgs84: Double,
//    var XPosWgs84: Double,
//    @PropertyElement
//    var YPos: Int,
//    @PropertyElement
//    var YPosWgs84: Double,
    @PropertyElement(name = "addr")
    var addr: String,
//    @PropertyElement
//    var mgtStaDd: Int,
//    @PropertyElement
//    var pcrPsblYn: String,
//    @PropertyElement
//    var ratPsblYn: String,
//    @PropertyElement
//    var recuClCd: Int,
//    @PropertyElement
//    var sgguCdNm: String,
    @PropertyElement(name = "sidoCdNm")
    var sidoCdNm: String,
    @PropertyElement(name="yadmNm")
    var yadmNm: String,
//    @PropertyElement
//    val ykihoEnc: String
)
