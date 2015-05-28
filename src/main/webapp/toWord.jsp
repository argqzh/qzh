<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<?mso-application progid="Word.Document"?>
<%@page contentType="application/msword; charset=UTF-8"%>
<%@page import="com.mseeworld.qzh.util.ImageOperation"%>
<%

    StringBuilder str = new StringBuilder();
    //取得图片的base64码  
    String url = ImageOperation.getGeoServerGetMap(request.getParameter("host"),
            request.getParameter("layers"),
            request.getParameter("bbox"),
            request.getParameter("width"),
            request.getParameter("height")
    );
//    String url = request.getParameter("url");
    str.append(ImageOperation.getImageBinary(url));

    String imgWidth = request.getParameter("width");
    String imgHeight = request.getParameter("height");
    int maxw =  414, maxh = 600;
    int imgw = Integer.parseInt(imgWidth);
    int imgh = Integer.parseInt(imgHeight);
    float ratio1 = maxw/maxh;
    float ratio2 = imgw/imgh;
    int scalw, scalh;
    if(ratio2>ratio1){
      scalh = imgh * maxw/imgw;
      scalw = maxw;
    }else{
      scalh = maxh;
      scalw = imgw * maxh/imgh;
      
    }

    String images = str.toString();//images就是图片的base64码  
    //此处的strExpFileName就是ExportWord.jsp中上面的变量名  
    String strExpFileName = new String("权证图片".getBytes("utf-8"), "8859_1");

    response.addHeader("Content-Disposition", "attachment;filename=" + strExpFileName + ".doc");
%>
<w:wordDocument xmlns:aml="http://schemas.microsoft.com/aml/2001/core" xmlns:wpc="http://schemas.microsoft.com/office/word/2010/wordprocessingCanvas" xmlns:dt="uuid:C2F41010-65B3-11d1-A29F-00AA00C14882" xmlns:mc="http://schemas.openxmlformats.org/markup-compatibility/2006" xmlns:o="urn:schemas-microsoft-com:office:office" xmlns:v="urn:schemas-microsoft-com:vml" xmlns:w10="urn:schemas-microsoft-com:office:word" xmlns:w="http://schemas.microsoft.com/office/word/2003/wordml" xmlns:wx="http://schemas.microsoft.com/office/word/2003/auxHint" xmlns:wne="http://schemas.microsoft.com/office/word/2006/wordml" xmlns:wsp="http://schemas.microsoft.com/office/word/2003/wordml/sp2" xmlns:sl="http://schemas.microsoft.com/schemaLibrary/2003/core" w:macrosPresent="no" w:embeddedObjPresent="no" w:ocxPresent="no" xml:space="preserve">
<w:ignoreSubtree w:val="http://schemas.microsoft.com/office/word/2003/wordml/sp2"/>
<o:DocumentProperties>
<o:Author>xy</o:Author>
<o:LastAuthor>xy</o:LastAuthor>
<o:Revision>2</o:Revision>
<o:TotalTime>0</o:TotalTime>
<o:Created>2015-03-27T02:03:00Z</o:Created>
<o:LastSaved>2015-03-27T02:03:00Z</o:LastSaved>
<o:Pages>1</o:Pages>
<o:Words>0</o:Words>
<o:Characters>1</o:Characters>
<o:Lines>1</o:Lines>
<o:Paragraphs>1</o:Paragraphs>
<o:CharactersWithSpaces>1</o:CharactersWithSpaces>
<o:Version>14</o:Version>
</o:DocumentProperties>
<w:fonts>
<w:defaultFonts w:ascii="Calibri" w:fareast="宋体" w:h-ansi="Calibri" w:cs="Times New Roman"/>
<w:font w:name="Times New Roman">
<w:panose-1 w:val="02020603050405020304"/>
<w:charset w:val="00"/>
<w:family w:val="Roman"/>
<w:pitch w:val="variable"/>
<w:sig w:usb-0="E0002AFF" w:usb-1="C0007841" w:usb-2="00000009" w:usb-3="00000000" w:csb-0="000001FF" w:csb-1="00000000"/>
</w:font>
<w:font w:name="宋体">
<w:altName w:val="SimSun"/>
<w:panose-1 w:val="02010600030101010101"/>
<w:charset w:val="86"/>
<w:family w:val="auto"/>
<w:pitch w:val="variable"/>
<w:sig w:usb-0="00000003" w:usb-1="288F0000" w:usb-2="00000016" w:usb-3="00000000" w:csb-0="00040001" w:csb-1="00000000"/>
</w:font>
<w:font w:name="宋体">
<w:altName w:val="SimSun"/>
<w:panose-1 w:val="02010600030101010101"/>
<w:charset w:val="86"/>
<w:family w:val="auto"/>
<w:pitch w:val="variable"/>
<w:sig w:usb-0="00000003" w:usb-1="288F0000" w:usb-2="00000016" w:usb-3="00000000" w:csb-0="00040001" w:csb-1="00000000"/>
</w:font>
<w:font w:name="Calibri">
<w:panose-1 w:val="020F0502020204030204"/>
<w:charset w:val="00"/>
<w:family w:val="Swiss"/>
<w:pitch w:val="variable"/>
<w:sig w:usb-0="E00002FF" w:usb-1="4000ACFF" w:usb-2="00000001" w:usb-3="00000000" w:csb-0="0000019F" w:csb-1="00000000"/>
</w:font>
<w:font w:name="@宋体">
<w:panose-1 w:val="02010600030101010101"/>
<w:charset w:val="86"/>
<w:family w:val="auto"/>
<w:pitch w:val="variable"/>
<w:sig w:usb-0="00000003" w:usb-1="288F0000" w:usb-2="00000016" w:usb-3="00000000" w:csb-0="00040001" w:csb-1="00000000"/>
</w:font>
</w:fonts>
<w:styles>
<w:versionOfBuiltInStylenames w:val="7"/>
<w:latentStyles w:defLockedState="off" w:latentStyleCount="267">
<w:lsdException w:name="Normal"/>
<w:lsdException w:name="heading 1"/>
<w:lsdException w:name="heading 2"/>
<w:lsdException w:name="heading 3"/>
<w:lsdException w:name="heading 4"/>
<w:lsdException w:name="heading 5"/>
<w:lsdException w:name="heading 6"/>
<w:lsdException w:name="heading 7"/>
<w:lsdException w:name="heading 8"/>
<w:lsdException w:name="heading 9"/>
<w:lsdException w:name="toc 1"/>
<w:lsdException w:name="toc 2"/>
<w:lsdException w:name="toc 3"/>
<w:lsdException w:name="toc 4"/>
<w:lsdException w:name="toc 5"/>
<w:lsdException w:name="toc 6"/>
<w:lsdException w:name="toc 7"/>
<w:lsdException w:name="toc 8"/>
<w:lsdException w:name="toc 9"/>
<w:lsdException w:name="caption"/>
<w:lsdException w:name="Title"/>
<w:lsdException w:name="Default Paragraph Font"/>
<w:lsdException w:name="Subtitle"/>
<w:lsdException w:name="Strong"/>
<w:lsdException w:name="Emphasis"/>
<w:lsdException w:name="Table Grid"/>
<w:lsdException w:name="Placeholder Text"/>
<w:lsdException w:name="No Spacing"/>
<w:lsdException w:name="Light Shading"/>
<w:lsdException w:name="Light List"/>
<w:lsdException w:name="Light Grid"/>
<w:lsdException w:name="Medium Shading 1"/>
<w:lsdException w:name="Medium Shading 2"/>
<w:lsdException w:name="Medium List 1"/>
<w:lsdException w:name="Medium List 2"/>
<w:lsdException w:name="Medium Grid 1"/>
<w:lsdException w:name="Medium Grid 2"/>
<w:lsdException w:name="Medium Grid 3"/>
<w:lsdException w:name="Dark List"/>
<w:lsdException w:name="Colorful Shading"/>
<w:lsdException w:name="Colorful List"/>
<w:lsdException w:name="Colorful Grid"/>
<w:lsdException w:name="Light Shading Accent 1"/>
<w:lsdException w:name="Light List Accent 1"/>
<w:lsdException w:name="Light Grid Accent 1"/>
<w:lsdException w:name="Medium Shading 1 Accent 1"/>
<w:lsdException w:name="Medium Shading 2 Accent 1"/>
<w:lsdException w:name="Medium List 1 Accent 1"/>
<w:lsdException w:name="Revision"/>
<w:lsdException w:name="List Paragraph"/>
<w:lsdException w:name="Quote"/>
<w:lsdException w:name="Intense Quote"/>
<w:lsdException w:name="Medium List 2 Accent 1"/>
<w:lsdException w:name="Medium Grid 1 Accent 1"/>
<w:lsdException w:name="Medium Grid 2 Accent 1"/>
<w:lsdException w:name="Medium Grid 3 Accent 1"/>
<w:lsdException w:name="Dark List Accent 1"/>
<w:lsdException w:name="Colorful Shading Accent 1"/>
<w:lsdException w:name="Colorful List Accent 1"/>
<w:lsdException w:name="Colorful Grid Accent 1"/>
<w:lsdException w:name="Light Shading Accent 2"/>
<w:lsdException w:name="Light List Accent 2"/>
<w:lsdException w:name="Light Grid Accent 2"/>
<w:lsdException w:name="Medium Shading 1 Accent 2"/>
<w:lsdException w:name="Medium Shading 2 Accent 2"/>
<w:lsdException w:name="Medium List 1 Accent 2"/>
<w:lsdException w:name="Medium List 2 Accent 2"/>
<w:lsdException w:name="Medium Grid 1 Accent 2"/>
<w:lsdException w:name="Medium Grid 2 Accent 2"/>
<w:lsdException w:name="Medium Grid 3 Accent 2"/>
<w:lsdException w:name="Dark List Accent 2"/>
<w:lsdException w:name="Colorful Shading Accent 2"/>
<w:lsdException w:name="Colorful List Accent 2"/>
<w:lsdException w:name="Colorful Grid Accent 2"/>
<w:lsdException w:name="Light Shading Accent 3"/>
<w:lsdException w:name="Light List Accent 3"/>
<w:lsdException w:name="Light Grid Accent 3"/>
<w:lsdException w:name="Medium Shading 1 Accent 3"/>
<w:lsdException w:name="Medium Shading 2 Accent 3"/>
<w:lsdException w:name="Medium List 1 Accent 3"/>
<w:lsdException w:name="Medium List 2 Accent 3"/>
<w:lsdException w:name="Medium Grid 1 Accent 3"/>
<w:lsdException w:name="Medium Grid 2 Accent 3"/>
<w:lsdException w:name="Medium Grid 3 Accent 3"/>
<w:lsdException w:name="Dark List Accent 3"/>
<w:lsdException w:name="Colorful Shading Accent 3"/>
<w:lsdException w:name="Colorful List Accent 3"/>
<w:lsdException w:name="Colorful Grid Accent 3"/>
<w:lsdException w:name="Light Shading Accent 4"/>
<w:lsdException w:name="Light List Accent 4"/>
<w:lsdException w:name="Light Grid Accent 4"/>
<w:lsdException w:name="Medium Shading 1 Accent 4"/>
<w:lsdException w:name="Medium Shading 2 Accent 4"/>
<w:lsdException w:name="Medium List 1 Accent 4"/>
<w:lsdException w:name="Medium List 2 Accent 4"/>
<w:lsdException w:name="Medium Grid 1 Accent 4"/>
<w:lsdException w:name="Medium Grid 2 Accent 4"/>
<w:lsdException w:name="Medium Grid 3 Accent 4"/>
<w:lsdException w:name="Dark List Accent 4"/>
<w:lsdException w:name="Colorful Shading Accent 4"/>
<w:lsdException w:name="Colorful List Accent 4"/>
<w:lsdException w:name="Colorful Grid Accent 4"/>
<w:lsdException w:name="Light Shading Accent 5"/>
<w:lsdException w:name="Light List Accent 5"/>
<w:lsdException w:name="Light Grid Accent 5"/>
<w:lsdException w:name="Medium Shading 1 Accent 5"/>
<w:lsdException w:name="Medium Shading 2 Accent 5"/>
<w:lsdException w:name="Medium List 1 Accent 5"/>
<w:lsdException w:name="Medium List 2 Accent 5"/>
<w:lsdException w:name="Medium Grid 1 Accent 5"/>
<w:lsdException w:name="Medium Grid 2 Accent 5"/>
<w:lsdException w:name="Medium Grid 3 Accent 5"/>
<w:lsdException w:name="Dark List Accent 5"/>
<w:lsdException w:name="Colorful Shading Accent 5"/>
<w:lsdException w:name="Colorful List Accent 5"/>
<w:lsdException w:name="Colorful Grid Accent 5"/>
<w:lsdException w:name="Light Shading Accent 6"/>
<w:lsdException w:name="Light List Accent 6"/>
<w:lsdException w:name="Light Grid Accent 6"/>
<w:lsdException w:name="Medium Shading 1 Accent 6"/>
<w:lsdException w:name="Medium Shading 2 Accent 6"/>
<w:lsdException w:name="Medium List 1 Accent 6"/>
<w:lsdException w:name="Medium List 2 Accent 6"/>
<w:lsdException w:name="Medium Grid 1 Accent 6"/>
<w:lsdException w:name="Medium Grid 2 Accent 6"/>
<w:lsdException w:name="Medium Grid 3 Accent 6"/>
<w:lsdException w:name="Dark List Accent 6"/>
<w:lsdException w:name="Colorful Shading Accent 6"/>
<w:lsdException w:name="Colorful List Accent 6"/>
<w:lsdException w:name="Colorful Grid Accent 6"/>
<w:lsdException w:name="Subtle Emphasis"/>
<w:lsdException w:name="Intense Emphasis"/>
<w:lsdException w:name="Subtle Reference"/>
<w:lsdException w:name="Intense Reference"/>
<w:lsdException w:name="Book Title"/>
<w:lsdException w:name="Bibliography"/>
<w:lsdException w:name="TOC Heading"/>
</w:latentStyles>
<w:style w:type="paragraph" w:default="on" w:styleId="a">
<w:name w:val="Normal"/>
<wx:uiName wx:val="正文"/>
<w:pPr>
<w:widowControl w:val="off"/>
<w:jc w:val="both"/>
</w:pPr>
<w:rPr>
<wx:font wx:val="Calibri"/>
<w:kern w:val="2"/>
<w:sz w:val="21"/>
<w:sz-cs w:val="22"/>
<w:lang w:val="EN-US" w:fareast="ZH-CN" w:bidi="AR-SA"/>
</w:rPr>
</w:style>
<w:style w:type="character" w:default="on" w:styleId="a0">
<w:name w:val="Default Paragraph Font"/>
<wx:uiName wx:val="默认段落字体"/>
</w:style>
<w:style w:type="table" w:default="on" w:styleId="a1">
<w:name w:val="Normal Table"/>
<wx:uiName wx:val="普通表格"/>
<w:rPr>
<wx:font wx:val="Calibri"/>
<w:lang w:val="EN-US" w:fareast="ZH-CN" w:bidi="AR-SA"/>
</w:rPr>
<w:tblPr>
<w:tblInd w:w="0" w:type="dxa"/>
<w:tblCellMar>
<w:top w:w="0" w:type="dxa"/>
<w:left w:w="108" w:type="dxa"/>
<w:bottom w:w="0" w:type="dxa"/>
<w:right w:w="108" w:type="dxa"/>
</w:tblCellMar>
</w:tblPr>
</w:style>
<w:style w:type="list" w:default="on" w:styleId="a2">
<w:name w:val="No List"/>
<wx:uiName wx:val="无列表"/>
</w:style>
</w:styles>
<w:shapeDefaults>
<o:shapedefaults v:ext="edit" spidmax="1026"/>
<o:shapelayout v:ext="edit">
<o:idmap v:ext="edit" data="1"/>
</o:shapelayout>
</w:shapeDefaults>
<w:docPr>
<w:view w:val="print"/>
<w:zoom w:percent="100"/>
<w:doNotEmbedSystemFonts/>
<w:bordersDontSurroundHeader/>
<w:bordersDontSurroundFooter/>
<w:proofState w:grammar="clean"/>
<w:defaultTabStop w:val="420"/>
<w:drawingGridVerticalSpacing w:val="156"/>
<w:displayHorizontalDrawingGridEvery w:val="0"/>
<w:displayVerticalDrawingGridEvery w:val="2"/>
<w:punctuationKerning/>
<w:characterSpacingControl w:val="CompressPunctuation"/>
<w:optimizeForBrowser/>
<w:allowPNG/>
<w:validateAgainstSchema/>
<w:saveInvalidXML w:val="off"/>
<w:ignoreMixedContent w:val="off"/>
<w:alwaysShowPlaceholderText w:val="off"/>
<w:compat>
<w:spaceForUL/>
<w:balanceSingleByteDoubleByteWidth/>
<w:doNotLeaveBackslashAlone/>
<w:ulTrailSpace/>
<w:doNotExpandShiftReturn/>
<w:adjustLineHeightInTable/>
<w:breakWrappedTables/>
<w:snapToGridInCell/>
<w:wrapTextWithPunct/>
<w:useAsianBreakRules/>
<w:dontGrowAutofit/>
<w:useFELayout/>
</w:compat>
<wsp:rsids>
<wsp:rsidRoot wsp:val="006402A0"/>
<wsp:rsid wsp:val="00277ECB"/>
<wsp:rsid wsp:val="00471605"/>
<wsp:rsid wsp:val="005A44E0"/>
<wsp:rsid wsp:val="006402A0"/>
<wsp:rsid wsp:val="00D90E8C"/>
<wsp:rsid wsp:val="00DA665B"/>
</wsp:rsids>
</w:docPr>
<w:body>
<wx:sect>
<w:p wsp:rsidR="00DA665B" wsp:rsidRDefault="00471605">
<w:r>
<w:pict>
<v:shapetype id="_x0000_t75" coordsize="21600,21600" o:spt="75" o:preferrelative="t" path="m@4@5l@4@11@9@11@9@5xe" filled="f" stroked="f">
<v:stroke joinstyle="miter"/>
<v:formulas>
<v:f eqn="if lineDrawn pixelLineWidth 0"/>
<v:f eqn="sum @0 1 0"/>
<v:f eqn="sum 0 0 @1"/>
<v:f eqn="prod @2 1 2"/>
<v:f eqn="prod @3 21600 pixelWidth"/>
<v:f eqn="prod @3 21600 pixelHeight"/>
<v:f eqn="sum @0 0 1"/>
<v:f eqn="prod @6 1 2"/>
<v:f eqn="prod @7 21600 pixelWidth"/>
<v:f eqn="sum @8 21600 0"/>
<v:f eqn="prod @7 21600 pixelHeight"/>
<v:f eqn="sum @10 21600 0"/>
</v:formulas>
<v:path o:extrusionok="f" gradientshapeok="t" o:connecttype="rect"/>
<o:lock v:ext="edit" aspectratio="t"/>
</v:shapetype>
<w:binData w:name="wordml://02000001.jpg" xml:space="preserve">
<%=images%>
</w:binData>
<v:shape id="_x0000_i1025" type="#_x0000_t75" style="width:<%=scalw%>pt;height:<%=scalh%>pt;">
<v:imagedata src="wordml://02000001.jpg" o:title="M07_ccdimg"/>
</v:shape>
</w:pict>
</w:r>
</w:p>
<w:sectPr wsp:rsidR="00DA665B">
<w:pgSz w:w="11906" w:h="16838"/>
<w:pgMar w:top="1440" w:right="1800" w:bottom="1440" w:left="1800" w:header="851" w:footer="992" w:gutter="0"/>
<w:cols w:space="425"/>
<w:docGrid w:type="lines" w:line-pitch="312"/>
</w:sectPr>
</wx:sect>
</w:body>
</w:wordDocument>