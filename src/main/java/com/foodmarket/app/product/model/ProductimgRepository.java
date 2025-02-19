//package com.foodmarket.app.product.model;
//
//import java.awt.image.BufferedImage;
//import java.io.ByteArrayInputStream;
//import java.io.IOException;
//import java.io.StringWriter;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.imageio.ImageIO;
//
//import org.apache.logging.log4j.Logger;
//import org.apache.tomcat.util.codec.binary.Base64;
//import org.apache.tomcat.util.http.fileupload.IOUtils;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.http.HttpInputMessage;
//import org.springframework.http.HttpOutputMessage;
//import org.springframework.http.MediaType;
//import org.springframework.http.converter.AbstractHttpMessageConverter;
//import org.springframework.http.converter.HttpMessageNotReadableException;
//import org.springframework.http.converter.HttpMessageNotWritableException;
//import org.springframework.stereotype.Repository;
//
//
//
//@Repository  // 可省略
//public class ProductimgRepository extends
//AbstractHttpMessageConverter<BufferedImage> {
//
//private Logger logger = Logger.getLogger(this.getClass());
//
//public ProductimgRepository() {
//
//List<MediaType> mediaTypes = new ArrayList<MediaType>();
//String[] supportedMediaTypes = ImageIO.getReaderMIMETypes();
//for (String supportedMediaType : supportedMediaTypes) {
//    String[] typeAndSubtype = supportedMediaType.split("/");
//    mediaTypes.add(new MediaType(typeAndSubtype[0], typeAndSubtype[1]));
//}
//
//setSupportedMediaTypes(mediaTypes);   
//}
//
//@Override
//protected boolean supports(Class<?> clazz) {
//return clazz.equals(BufferedImage.class);
//}
//
///** This uses a data uri. If that's not you, 
//* you'll need to modify this method to decode the base64 data
//* straight. */
//@Override
//protected BufferedImage readInternal(Class<? extends BufferedImage> clazz,
//    HttpInputMessage inputMessage) throws IOException,
//    HttpMessageNotReadableException {
//
//StringWriter writer = new StringWriter();
//IOUtils.copy(inputMessage.getBody(), writer, "UTF-8");
//String imageInBase64 = writer.toString();
//int startOfBase64Data = imageInBase64.indexOf(",") + 1;
//imageInBase64 = imageInBase64.substring(startOfBase64Data,
//        imageInBase64.length());
//
//if (Base64.isBase64(imageInBase64) == false) {
//    logger.error("************************************************");
//    logger.error("*** IMAGE IN REQUEST IS NOT IN BASE64 FORMAT ***");
//    logger.error("************************************************");
//}
//
//byte[] decodeBase64 = Base64.decodeBase64(imageInBase64);
//BufferedImage image = ImageIO.read(new ByteArrayInputStream(
//        decodeBase64));
//return image;
//
//}     
//
//@Override
//protected void writeInternal(BufferedImage t,
//    HttpOutputMessage outputMessage) throws IOException,
//    HttpMessageNotWritableException {
//ImageIO.write(t, "jpeg", outputMessage.getBody());
//outputMessage.getBody().flush();
//}
//
//}