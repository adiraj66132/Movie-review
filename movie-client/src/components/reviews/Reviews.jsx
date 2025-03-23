import React, { useState } from 'react'
import { useEffect, useRef } from 'react';
import api from '../../api/axiosConfig';
import { Container, Row, Col } from 'react-bootstrap';
import { useParams } from 'react-router-dom';
import ReviewForm from './ReviewForm';
import "./Reviews.css";

const Reviews = () => {

    const [movie, setMovie] = useState();
    const [reviews, setReviews] = useState([]);

    const revText = useRef();
    const { movieId } = useParams();

    const getMovieData = async (id) => {
        try{
            const response = await api.get(`/api/v1/movies/${movieId}`);
            const fetchedMovie = response.data;
            setMovie(fetchedMovie);
            setReviews(fetchedMovie.reviewIds);
        }
        catch(err){
            console.log(err);
        }
    }

    const addReview = async (e) => {
        e.preventDefault();

        const rev = revText.current;

        const response = await api.post("/api/v1/reviews", {
            reviewBody: rev.value,
            imdbId: movieId
        });

        rev.value = "";
        
        getMovieData();  // Refreshes reviews
    }

    useEffect(() => {
        getMovieData(movieId);
    }, []);


  return (
    <Container style={{marginTop: '1rem'}}>
        <Row>
            <Col><h3>Reviews</h3></Col>
        </Row>
        <Row className="mt-2">
            <Col>
                <img src={movie?.poster} alt="" />
            </Col>
            <Col>
                {
                    <>
                        <Row>
                            <Col>
                                <ReviewForm handleSubmit={addReview} revText={revText} labelText = "Write a Review?" />  
                            </Col>
                        </Row>
                        <Row>
                            <Col>
                                <hr />
                            </Col>
                        </Row>
                    </>
                }
                {
                    reviews?.map((review) => {
                        return(
                            <div key={review.id.timestamp}>
                                <Row>
                                    <Col>{review.body}</Col>
                                </Row>
                                <Row>
                                    <Col>
                                        <hr />
                                    </Col>
                                </Row>                                
                            </div>
                        )
                    })
                }
            </Col>
        </Row>
        <Row>
            <Col>
                <hr />
            </Col>
        </Row>        
    </Container>
  )
}

export default Reviews;