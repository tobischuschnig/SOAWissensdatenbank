
/**
 * KnowledgeServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package iknowsoa;

    /**
     *  KnowledgeServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class KnowledgeServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public KnowledgeServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public KnowledgeServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for load method
            * override this method for handling normal response from load operation
            */
           public void receiveResultload(
                    iknowsoa.KnowledgeServiceStub.LoadResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from load operation
           */
            public void receiveErrorload(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getEntry method
            * override this method for handling normal response from getEntry operation
            */
           public void receiveResultgetEntry(
                    iknowsoa.KnowledgeServiceStub.GetEntryResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getEntry operation
           */
            public void receiveErrorgetEntry(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for save method
            * override this method for handling normal response from save operation
            */
           public void receiveResultsave(
                    iknowsoa.KnowledgeServiceStub.SaveResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from save operation
           */
            public void receiveErrorsave(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for add method
            * override this method for handling normal response from add operation
            */
           public void receiveResultadd(
                    iknowsoa.KnowledgeServiceStub.AddResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from add operation
           */
            public void receiveErroradd(java.lang.Exception e) {
            }
                


    }
    