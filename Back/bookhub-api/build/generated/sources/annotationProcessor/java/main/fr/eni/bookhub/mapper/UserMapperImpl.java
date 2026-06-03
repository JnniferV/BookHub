package fr.eni.bookhub.mapper;

import fr.eni.bookhub.bo.Loan;
import fr.eni.bookhub.bo.Reservation;
import fr.eni.bookhub.bo.User;
import fr.eni.bookhub.dto.authentification.RegisterRequest;
import fr.eni.bookhub.dto.authentification.RegisterResponse;
import fr.eni.bookhub.dto.authentification.UserResponse;
import fr.eni.bookhub.dto.authentification.UserUpdateResponse;
import fr.eni.bookhub.dto.emprunts.LoanDTO;
import fr.eni.bookhub.dto.reservation.ReservationDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-27T20:06:41+0200",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-9.3.1.jar, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toEntity(RegisterRequest request) {
        if ( request == null ) {
            return null;
        }

        User user = new User();

        user.setEmail( request.getEmail() );
        user.setFirstName( request.getFirstName() );
        user.setLastName( request.getLastName() );
        user.setPhone( request.getPhone() );
        user.setTosAcceptationDate( request.getTosAcceptationDate() );

        return user;
    }

    @Override
    public RegisterResponse toRegisterResponse(User user) {
        if ( user == null ) {
            return null;
        }

        RegisterResponse.RegisterResponseBuilder registerResponse = RegisterResponse.builder();

        registerResponse.email( user.getEmail() );
        registerResponse.firstName( user.getFirstName() );
        registerResponse.lastName( user.getLastName() );

        registerResponse.role( user.getRole().name() );

        return registerResponse.build();
    }

    @Override
    public UserResponse toUserResponse(User user) {
        if ( user == null ) {
            return null;
        }

        UserResponse userResponse = new UserResponse();

        userResponse.setId( user.getId() );
        userResponse.setEmail( user.getEmail() );
        userResponse.setFirstName( user.getFirstName() );
        userResponse.setLastName( user.getLastName() );
        userResponse.setPhone( user.getPhone() );
        userResponse.setActive( user.isActive() );

        userResponse.setRole( user.getRole().name() );

        return userResponse;
    }

    @Override
    public UserUpdateResponse toUpdateResponse(User user) {
        if ( user == null ) {
            return null;
        }

        UserUpdateResponse userUpdateResponse = new UserUpdateResponse();

        userUpdateResponse.setEmail( user.getEmail() );
        userUpdateResponse.setFirstName( user.getFirstName() );
        userUpdateResponse.setLastName( user.getLastName() );
        userUpdateResponse.setPhone( user.getPhone() );

        userUpdateResponse.setRole( user.getRole().name() );

        return userUpdateResponse;
    }

    @Override
    public ReservationDTO toReservationDTO(Reservation reservation) {
        if ( reservation == null ) {
            return null;
        }

        ReservationDTO reservationDTO = new ReservationDTO();

        reservationDTO.setId( reservation.getId() );
        reservationDTO.setUser( toUserResponse( reservation.getUser() ) );
        reservationDTO.setBook( reservation.getBook() );
        reservationDTO.setReservationDate( reservation.getReservationDate() );
        reservationDTO.setRankInLine( reservation.getRankInLine() );
        reservationDTO.setStatus( reservation.getStatus() );

        return reservationDTO;
    }

    @Override
    public LoanDTO toLoanDto(Loan loan) {
        if ( loan == null ) {
            return null;
        }

        LoanDTO loanDTO = new LoanDTO();

        loanDTO.setId( loan.getId() );
        loanDTO.setUser( toUserResponse( loan.getUser() ) );
        loanDTO.setBook( loan.getBook() );
        loanDTO.setLoanDate( loan.getLoanDate() );
        loanDTO.setDueDate( loan.getDueDate() );
        loanDTO.setReturnDate( loan.getReturnDate() );
        loanDTO.setStatus( loan.getStatus() );

        return loanDTO;
    }
}
