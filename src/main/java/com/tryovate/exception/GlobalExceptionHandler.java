package com.tryovate.exception;

import com.tryovate.constants.CandidateConstants;
import com.tryovate.dto.ResponseDto;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {//extends ResponseEntityExceptionHandler {


    // Handles @NotBlank, @NotNull, @Pattern etc.
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDto> handleValidationException(MethodArgumentNotValidException ex) {
        String errorMessage = ex.getBindingResult().getFieldErrors()
                .stream()
                .findFirst()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .orElse(CandidateConstants.MESSAGE_500);

        ResponseDto response = new ResponseDto(
                CandidateConstants.STATUS_400,
                errorMessage
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }



    // Handles other uncaught exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseDto> handleGenericException(Exception ex) {
        ResponseDto response = new ResponseDto(
                CandidateConstants.STATUS_500,
                CandidateConstants.MESSAGE_500
        );
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
//    @Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(
//            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
//        Map<String, String> validationErrors = new HashMap<>();
//        List<ObjectError> validationErrorList = ex.getBindingResult().getAllErrors();
//
//        validationErrorList.forEach((error) -> {
//            String fieldName = ((FieldError) error).getField();
//            String validationMsg = error.getDefaultMessage();
//            validationErrors.put(fieldName, validationMsg);
//        });
//        return new ResponseEntity<>(validationErrors, HttpStatus.BAD_REQUEST);
//    }



    @ExceptionHandler(CandidateAlreadyExistsException.class)
    public ResponseEntity<ResponseDto> handleCustomerAlreadyExistsException(CandidateAlreadyExistsException exception){
        return ResponseEntity
                .status(HttpStatus.EXPECTATION_FAILED)
                .body(new ResponseDto(CandidateConstants.STATUS_400, exception.getMessage()));

    }

    @ExceptionHandler(CandidateNotFoundException.class)
    public ResponseEntity<ResponseDto> handleCandidateNotFoundException(CandidateNotFoundException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ResponseDto(CandidateConstants.STATUS_404, ex.getMessage()));
    }

    @ExceptionHandler(NoCandidatesFoundException.class)
    public ResponseEntity<ResponseDto> handleNoCandidatesFoundException(NoCandidatesFoundException ex) {
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body(new ResponseDto("204", ex.getMessage()));
    }

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ErrorResponseDto> handleGlobalException(Exception exception,
//                                                                  WebRequest webRequest) {
//        ErrorResponseDto errorResponseDTO = new ErrorResponseDto(
//                webRequest.getDescription(false),
//                HttpStatus.INTERNAL_SERVER_ERROR,
//                exception.getMessage(),
//                LocalDateTime.now()
//        );
//        return new ResponseEntity<>(errorResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
//    }

//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<ErrorResponseDto> handleResourceNotFoundException(ResourceNotFoundException exception,
//                                                                            WebRequest webRequest) {
//        ErrorResponseDto errorResponseDTO = new ErrorResponseDto(
//                webRequest.getDescription(false),
//                HttpStatus.NOT_FOUND,
//                exception.getMessage(),
//                LocalDateTime.now()
//        );
//        return new ResponseEntity<>(errorResponseDTO, HttpStatus.NOT_FOUND);
//    }

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<ResponseDto> handleValidationExceptions(MethodArgumentNotValidException ex) {
//        String errorMessage = ex.getBindingResult().getAllErrors()
//                .stream()
//                .map(DefaultMessageSourceResolvable::getDefaultMessage)
//                .collect(Collectors.joining(", "));
//
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//                .body(new ResponseDto("400", errorMessage));
//    }
}
