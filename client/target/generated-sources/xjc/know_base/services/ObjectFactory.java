//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.04.21 at 11:14:04 AM MSK 
//


package know_base.services;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the know_base.services package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: know_base.services
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddRecordRequest }
     * 
     */
    public AddRecordRequest createAddRecordRequest() {
        return new AddRecordRequest();
    }

    /**
     * Create an instance of {@link AddLabelsRequest }
     * 
     */
    public AddLabelsRequest createAddLabelsRequest() {
        return new AddLabelsRequest();
    }

    /**
     * Create an instance of {@link ArrayOfId }
     * 
     */
    public ArrayOfId createArrayOfId() {
        return new ArrayOfId();
    }

    /**
     * Create an instance of {@link AddFileRequest }
     * 
     */
    public AddFileRequest createAddFileRequest() {
        return new AddFileRequest();
    }

    /**
     * Create an instance of {@link AddLabelRequest }
     * 
     */
    public AddLabelRequest createAddLabelRequest() {
        return new AddLabelRequest();
    }

    /**
     * Create an instance of {@link GetFileRequest }
     * 
     */
    public GetFileRequest createGetFileRequest() {
        return new GetFileRequest();
    }

    /**
     * Create an instance of {@link RemoveLabelRequest }
     * 
     */
    public RemoveLabelRequest createRemoveLabelRequest() {
        return new RemoveLabelRequest();
    }

    /**
     * Create an instance of {@link GetLabelsRequest }
     * 
     */
    public GetLabelsRequest createGetLabelsRequest() {
        return new GetLabelsRequest();
    }

    /**
     * Create an instance of {@link GetRecordsRequest }
     * 
     */
    public GetRecordsRequest createGetRecordsRequest() {
        return new GetRecordsRequest();
    }

    /**
     * Create an instance of {@link GetRecordsByLabelRequest }
     * 
     */
    public GetRecordsByLabelRequest createGetRecordsByLabelRequest() {
        return new GetRecordsByLabelRequest();
    }

    /**
     * Create an instance of {@link AddRecordResponse }
     * 
     */
    public AddRecordResponse createAddRecordResponse() {
        return new AddRecordResponse();
    }

    /**
     * Create an instance of {@link AddLabelResponse }
     * 
     */
    public AddLabelResponse createAddLabelResponse() {
        return new AddLabelResponse();
    }

    /**
     * Create an instance of {@link GetFileResponse }
     * 
     */
    public GetFileResponse createGetFileResponse() {
        return new GetFileResponse();
    }

    /**
     * Create an instance of {@link GetLabelsResponse }
     * 
     */
    public GetLabelsResponse createGetLabelsResponse() {
        return new GetLabelsResponse();
    }

    /**
     * Create an instance of {@link Label }
     * 
     */
    public Label createLabel() {
        return new Label();
    }

    /**
     * Create an instance of {@link GetRecordsResponse }
     * 
     */
    public GetRecordsResponse createGetRecordsResponse() {
        return new GetRecordsResponse();
    }

    /**
     * Create an instance of {@link Record }
     * 
     */
    public Record createRecord() {
        return new Record();
    }

    /**
     * Create an instance of {@link GetRecordsByLabelResponse }
     * 
     */
    public GetRecordsByLabelResponse createGetRecordsByLabelResponse() {
        return new GetRecordsByLabelResponse();
    }

    /**
     * Create an instance of {@link Response }
     * 
     */
    public Response createResponse() {
        return new Response();
    }

}