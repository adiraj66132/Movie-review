import React from 'react'
import { useParams } from 'react-router-dom'
import ReactPlayer from 'react-player'
import './Trailer.css'

const Trailer = () => {
    const { ytLinkId } = useParams();


  return (
    <div className='react-player-container'>
        <ReactPlayer controls='true' playing='true' url={`https://www.youtube.com/watch?v=${ytLinkId}`} width='100%' height='100%' />
    </div>
  )
}

export default Trailer