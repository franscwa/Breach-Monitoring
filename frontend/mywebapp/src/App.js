import React, { useState, useEffect } from 'react';
import axios from 'axios';

const App = () => {
  const [posts, setPosts] = useState([]);

  useEffect(() => {
    axios
      .get('https://jsonplaceholder.typicode.com/posts')
      .then(res => setPosts(res.data));
  }, []);

  const handleAddPost = () => {
    axios
      .post('https://jsonplaceholder.typicode.com/posts', {
        title: 'new post',
        body: 'new body'
      })
      .then(res => setPosts([...posts, res.data]));
  };

  const handleUpdatePost = () => {
    axios
      .put(`https://jsonplaceholder.typicode.com/posts/${posts[0].id}`, {
        title: 'updated post',
        body: 'updated body'
      })
      .then(res =>
        setPosts(
          posts.map(post => (post.id === res.data.id ? res.data : post))
        )
      );
  };

  const handleDeletePost = () => {
    axios
      .delete(`https://jsonplaceholder.typicode.com/posts/${posts[0].id}`)
      .then(() => setPosts(posts.slice(1)));
  };

  return (
    <div>
      <button onClick={handleAddPost}>Add Post</button>
      <button onClick={handleUpdatePost}>Update Post</button>
      <button onClick={handleDeletePost}>Delete Post</button>
      {posts.map(post => (
        <div key={post.id}>
          <h3>{post.title}</h3>
          <p>{post.body}</p>
        </div>
      ))}
    </div>
  );
};

export default App;