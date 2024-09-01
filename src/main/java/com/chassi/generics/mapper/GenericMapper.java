//package com.chassi.generics.mapper;
//
//import org.apache.catalina.mapper.Mapper;
//import org.mapstruct.factory.Mappers;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@org.mapstruct.Mapper
//public class GenericMapper {
//
//    private static Mapper mapper = Mappers.getMapper(PersonMapper.class); DozerBeanMapperBuilder.buildDefault();
//
//    public static <O, D > D parseObject(O origin, Class<D> destination){
//        return mapper.map(origin, destination);
//    }
//
//    public static <O, D > List<D> parseListObjects(List<O> origins, Class<D> destination){
//        List<D> destinationObjects = new ArrayList<D>();
//
//        for( O o : origins) {
//            destinationObjects.add(mapper.map(o, destination));
//        }
//
//        return destinationObjects;
//    }
//
//}
